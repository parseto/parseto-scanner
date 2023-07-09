package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO

object StepUpdate:
  def update(model: Model): StepMsg => (Model, Cmd[IO, Msg]) =
    case StepMsg.StepUpdate(step: Int) =>
      (
        model.copy(
          step = step
        ),
        Cmd.None
      )
