package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO

object RealTimeUpdate:
  def update(model: Model): RealTimeMsg => (Model, Cmd[IO, Msg]) =
    case RealTimeMsg.Tick(time: js.Date) =>
      (
        model.copy(
          time = time
        ),
        Cmd.None
      )
