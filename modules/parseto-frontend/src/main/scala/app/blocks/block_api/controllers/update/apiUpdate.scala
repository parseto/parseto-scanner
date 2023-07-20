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
import parseto.ApiModelPipe.in_appStates

object ApiUpdate:
  def update(model: BlockModel): ApiMsg => (BlockModel, Cmd[IO, ApiMsg]) =
    case ApiMsg.PreUpdate(page) =>
      (
        model.copy(apiModel =
          model.apiModel.copy(appStates =
            model.apiModel.appStates ++ Seq(
              ApiModelStateCase(
                number = ApiModelPipe.get_latest_number(model.apiModel) + 1,
                apiModelPageCase = page
              )
            )
          )
        ),
        Cmd.Batch(
          ApiPageCasePipe
            .in_PubCases(page)
            .map(pub =>
              CmdPipe.getDataCmd(
                pub,
                model
              ),
            )
        )
      )
    case ApiMsg.Update(pub) =>
      (
        model.copy(
          apiModel = model.apiModel.copy(appStates =
            model.apiModel
              .pipe(in_appStates)
              .map(
                ApiModelStateCasePipe
                  .update_PubData(pub, model.apiModel.appStates.length)
              )
          )
        ),
        Cmd.None
      )

    case ApiMsg.OkTx(txs) =>
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
      (model.copy(), Cmd.None)

    case ApiMsg.None =>
      (model.copy(), Cmd.None)

    case _ =>
      (model.copy(), Cmd.None)
