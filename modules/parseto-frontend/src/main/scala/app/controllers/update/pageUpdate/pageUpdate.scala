package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object PageUpdate:
  def update(model: Model): MobilePageMsg => (Model, Cmd[IO, Msg]) =
    case MobilePageMsg.PreUpdate(page: MobilePageCase) =>
      log2("update")(page)
      page match
        case _ =>
          (
            model.copy(
              appStates = model.appStates ++ Seq(
                StateCase(
                  number = ModelPipe.get_latest_number(model) + 1,
                  mobilePageCase = page
                )
              ),
              pointer = ModelPipe.get_latest_number(model) + 1
            ),
            Cmd.None
          )
