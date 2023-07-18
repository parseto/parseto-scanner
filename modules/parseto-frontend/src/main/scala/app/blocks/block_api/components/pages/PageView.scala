package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object ApiPageView:

  def view(model: ApiModel): Html[Msg] =
    div(
      `class` := s"flex justify-center"
    )(
      div("안녕"),
      div(model.txs.map(d => div(d.toString())))
    )
