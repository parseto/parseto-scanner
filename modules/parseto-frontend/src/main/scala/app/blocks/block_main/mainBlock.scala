package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MainBlockView:

  def view(model: ProdModel): Html[Msg] =
    div(
    )(
      List(ProdView.view(model), PureView.view(model), div()("3"))(1)
    )
