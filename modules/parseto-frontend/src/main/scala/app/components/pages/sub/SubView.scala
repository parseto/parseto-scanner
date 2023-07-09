package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object SubView:

  def view(model: Model): Html[Msg] =
    div(
      div(`class` := "bg-white h-14 items-center m-40 pt-10 text-3xl")(
        div(`class` := "text-center w-full font-bold p-10")("지금 당장 나에게 필요한 앱"),
        div(`class` := "text-center w-full font-bold")("지금 당장 견적 받기!")
      )
    )
