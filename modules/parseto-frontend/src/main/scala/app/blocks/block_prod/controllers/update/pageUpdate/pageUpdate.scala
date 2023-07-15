package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object PageUpdate:
  def update(model: BlockModel): MobilePageMsg => (BlockModel, Cmd[IO, Msg]) =
    case MobilePageMsg.PreUpdate(page: MobilePageCase) =>
      log2("모바일1")(page)
      page match
        case _ =>
          (
            model.copy(
              prodModel = model.prodModel.copy(
                appStates = model.prodModel.appStates ++ Seq(
                  StateCase(
                    number = ModelPipe.get_latest_number(model.prodModel) + 1,
                    mobilePageCase = page
                  )
                ),
                pointer = ModelPipe.get_latest_number(model.prodModel) + 1
              )
            ),
            Cmd.None
          )
    case MobilePageMsg.Next =>
      (
        model.copy(
        ),
        Cmd.Emit(
          MobilePageMsg.PreUpdate(
            model.prodModel.bizSector.filter(d => d.isClick)(0).page
          )
        )
      )
