package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object PureView:

  def view(model: Model): Html[Msg] =
    List(
      _P0.view(model),
      _P01_all.view(model),
      _P01_medi.view(model)
    )(2)
