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
  def update(model: BlockModel): ApiMsg => (BlockModel, Cmd[IO, Msg]) =
    case ApiMsg.PreUpdate(page) =>
      (
        model.copy(apiModel =
          model.apiModel.copy(
            appStates = model.apiModel.appStates ++ Seq(
              ApiModelStateCase(
                number = ApiModelPipe.get_latest_number(model.apiModel) + 1,
                apiModelPageCase = page
              )
            ),
            pointer = ApiModelPipe.get_latest_number(model.apiModel) + 1
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
          apiModel = model.apiModel.copy(
            appStates = model.apiModel
              .pipe(in_appStates)
              .map(
                ApiModelStateCasePipe
                  .update_PubData(pub, model.apiModel.appStates.length)
              ),
            bizSector = pub match
              case pub: PubCase.ApiPub =>
                pub.pub_m2.map(d => {
                  val p =
                    d.page match
                      case "P01xy" => MobilePageCase.P01x_matchSamples()
                      case _       => MobilePageCase.P01x_matchSamples()
                  BizSector(d.name, p, d.isClick.toBoolean)
                })
              case _ => model.apiModel.bizSector
              // List(BizSector())
          )
        ),
        pub match
          case pub: PubCase.ApiPub =>
            val bizs = pub.pub_m2.map(d => {
              val p =
                d.page match
                  case "P01xy" => MobilePageCase.P01x_matchSamples()
                  case _       => MobilePageCase.P01x_matchSamples()
              BizSector(d.name, p, d.isClick.toBoolean)
            })
            Cmd.Emit(
              BizSectorMsg.BizSectorInit(
                bizs
              )
            )
          case _ => Cmd.None
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
