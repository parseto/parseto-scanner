package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object PageView:

  def view(model: ProdModel): Html[Msg] =
    div(
      `class` := s"flex justify-between w-full h-[750px] px-40 pt-10 relative"
    )(
      SubView.view(model),
      MobileView.view(model)
    )
