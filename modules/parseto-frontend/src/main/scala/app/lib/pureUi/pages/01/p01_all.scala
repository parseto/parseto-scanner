package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object _P01_all:
  def view =
    // div(`class` := "galuxy-note-10")(
    List(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
          div(`class` := "text-lg font-bold")("어떤 업종을 운영하시나요?"),
          div(`class` := "grid grid-cols-3 gap-4 text-sm text-gray-600")(
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 bg-blue-600 text-white"
            )("의료"),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            ),
            button(
              `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300"
            )
          )
        ),
        button(
          `type` := "submit",
          `class` := "left-0 w-full flex py-4 justify-center font-medium bg-blue-600 text-white rounded-b-[20px]"
        )(p("다음"), p(`class` := "pl-2 font font-bold")(">"))
      )
    )
