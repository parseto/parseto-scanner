package parseto
import cats.data.EitherT
import cats.effect.IO
import io.circe.DecodingFailure
import io.circe.ParsingFailure
import io.circe.generic.semiauto.*
import io.circe.parser.*
import io.circe.syntax.*
import tyrian.Html.*
import tyrian.*
import tyrian.http.*
import scala.concurrent.duration.*
import scala.scalajs.js.annotation.*
import parseto.Log.log2
import scala.util.chaining.*

object ApiUpdate:
  def update(model: BlockModel): ApiMsg => (BlockModel, Cmd[IO, ApiMsg]) =
    case ApiMsg.GetData(url) =>
      (model.copy(), getApiData(url))

    case ApiMsg.OkTx(txs) =>
      log2("txs")(txs)
      (model.copy(apiModel = model.apiModel.copy(txs = txs)), Cmd.None)

    case ApiMsg.PubTxs(json) =>
      json.as[List[Transaction]] match
        case Right(v) =>
          (
            model.copy(apiModel = model.apiModel.copy(txs = v)),
            Cmd.None
          )
        case Left(_) =>
          (
            model.copy(),
            Cmd.Emit(ApiMsg.Error("Invalid transaction data"))
          )

    case ApiMsg.Error(err) =>
      log2("error")(err)
      (model.copy(), Cmd.None)

  def getApiData(url: String): Cmd[IO, ApiMsg] =
    Http.send(
      Request
        .get(url)
        .withTimeout(5.seconds),
      Decoder[ApiMsg](
        parseJson,
        onError => ApiMsg.Error("error :: http connect error")
      )
    )

  def parseJson(res: Response): ApiMsg =
    parse(res.body).pipe(log2("res.body")) match
      case Left(_) => ApiMsg.Error("Invalid json response")
      case Right(json) =>
        json.as[List[Transaction]] match
          case Right(v) => ApiMsg.OkTx(v)
          case Left(_)  => ApiMsg.Error("Invalid transaction data")
