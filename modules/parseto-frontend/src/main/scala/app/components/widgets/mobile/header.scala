package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MobileHeaderView:

  def view =
    div(`class` := "relative bg-white h-14 items-center border-b flex")(
      div(`class` := "text-center w-full font-bold")("Devscan service")
    )

  def viewBack =
    div(
      `class` := "flex justify-between px-6 bg-white h-14 items-center border-b "
    )(
      button(
        onClick(StepMsg.StepUpdate(0)),
        `class` := ""
      )("<"),
      button(`class` := "text-center w-full font-bold")("Devscan service"),
      button(`class` := "text-white")(">")
    )
