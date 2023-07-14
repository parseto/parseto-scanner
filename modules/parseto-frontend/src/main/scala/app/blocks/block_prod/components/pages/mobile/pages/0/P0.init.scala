package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P0_IntroView:
  def view(model: Model): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      s(
        // Clock.view(model),
        // Noti.view(model)
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
