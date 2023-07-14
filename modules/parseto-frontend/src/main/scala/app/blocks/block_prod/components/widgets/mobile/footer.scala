package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MobileFooterView:

  def view(css: String) =
    button(
      onClick(MobilePageMsg.Next),
      `type` := "submit",
      `class` := css
    )(
      p("다음"),
      p(`class` := "pl-2 font font-bold")(">")
    )
