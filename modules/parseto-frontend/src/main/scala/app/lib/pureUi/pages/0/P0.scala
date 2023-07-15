package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object _P0:
  def view: Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      s(
        div("2 : 52"),
        div(`class` := "flex justify-center pt-10")(
          div(`class` := "flex flex-col  content-center space-y-4")(
            div(
              `class` := "rounded-lg border border-white px-[10px] h-[105px] w-[340px] py-4 pb-6 bg-gray-600/30 hover:bg-green-600/20 cursor-pointer"
            )(
              div(`class` := "flex flex-col")(
                div(`class` := "text-base")(
                  div(`class` := "flex justify-between")(
                    div(`class` := "flex justify-end space-x-2")(
                      img(
                        `class` := "w-[20px] h-[20px]",
                        src := "https://avatars.githubusercontent.com/u/138956767?s=200&v=4"
                      ),
                      div(
                        `class` := "flex flex-col h-[20px]  justify-center content-center"
                      )("parseto soft.")
                    ),
                    div(
                      `class` := "flex flex-col h-[20px]  justify-center content-center"
                    )("27s ago")
                  ),
                  div(`class` := "text-left py-2")(
                    div(`class` := "font-bold")("새로운 서비스를 준비중 이신가요?"),
                    div("지금 견적 받기!")
                  )
                )
              )
            ),
            div(
              `class` := "rounded-lg border border-white px-[10px] h-[105px] w-[340px] py-4 pb-6 bg-gray-600/30 hover:bg-green-600/20 cursor-pointer"
            )(
              div(`class` := "flex flex-col")(
                div(`class` := "text-base")(
                  div(`class` := "flex justify-between")(
                    div(`class` := "flex justify-end space-x-2")(
                      img(
                        `class` := "w-[20px] h-[20px]",
                        src := "https://seeklogo.com/images/K/kakao-talk-logo-7542043DFC-seeklogo.com.png"
                      ),
                      div(
                        `class` := "flex flex-col h-[20px]  justify-center content-center"
                      )("전문가와 오픈톡")
                    ),
                    div(
                      `class` := "flex flex-col h-[20px]  justify-center content-center"
                    )("27s ago")
                  ),
                  div(`class` := "text-left py-2")(
                    div(`class` := "font-bold")("아이디어는 있는데... 어떻게 해야할지 모르겠다면"),
                    div("전문가와 커피챗 하기 >")
                  )
                )
              )
            )
          )
        )
      ),
      span(`class` := "cursor-pointer hover:bg-green-600/40")(
        "Left action button"
      ),
      span(`class` := "cursor-pointer hover:bg-green-600/40")(
        "right action button"
      )
    )
