package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object ClonePageView:

  def view(model: CloneModel): Html[Msg] =
    div(
      `class` := s"flex justify-center"
    )(
      div(
        `class` := s"w-[580px] h-screen "
      )(
        section(
          `class` := "px-5 py-4",
          style := "background: rgb(230, 243, 255);"
        )(
          div(`class` := "flex items-center")(
            img(
              src := "https://avatars.githubusercontent.com/u/138956767?s=200&v=4",
              `class` := "w-10 h-10 rounded",
              alt := "굿닥"
            ),
            div(`class` := "flex-1 ml-3 text-sm")(
              h1(`class` := "")("나에게 필요한 앱"),
              p(`class` := "font-bold")("지금 당장 견적 받기!")
            ),
            button(
              `class` := "rounded-lg px-3 py-1 text-xs text-white bg-blue-500"
            )("다운로드")
          )
        ),
        div(`class` := s"")(
          div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
            div(`class` := "text-lg font-bold")("어떤 업종을 운영하시나요?"),
            div(`class` := "grid grid-cols-3 gap-4 text-sm text-gray-600")(
              button(
                `class` := "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 bg-blue-600 text-white"
              )("MEDI"),
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
          )
        )
      )
    )
