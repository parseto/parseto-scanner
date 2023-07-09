package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MediView:

  def view(model: Model): Html[Msg] =
    div("의료")
