package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import tyrian.SVG.*
import tyrian.*

import scala.scalajs.js.annotation.*

import scalajs.js
import concurrent.duration.DurationInt

object Noti:
  def view(model: ProdModel) =
    div(`class` := "flex justify-center pt-10 ")(
      div(
        `class` := " flex flex-col  content-center space-y-4"
      )(
        div(
          `class` := " rounded-lg border border-white px-[10px] h-[105px] w-[340px] py-4 pb-6 bg-gray-600/30 hover:bg-green-600/20 cursor-pointer"
        )(
          div(`class` := "flex flex-col  ")(
            div(`class` := "text-base  ")(
              div(
                `class` := "flex justify-between"
              )(
                div(`class` := "flex justify-end space-x-2")(
                  img(
                    `class` := "w-[20px] h-[20px]",
                    src :=
                      "https://avatars.githubusercontent.com/u/138956767?s=200&v=4"
                  ),
                  div(
                    `class` := "flex flex-col h-[20px]  justify-center content-center"
                  )(
                    "parseto soft."
                  )
                ),
                div(
                  `class` := "flex flex-col h-[20px]  justify-center content-center"
                )(
                  s"${Dom.timeAgo(model.time.getTime(), model.init_time.getTime())}"
                )
              ),
              div(`class` := "text-left py-2  ")(
                div(
                  onClick(
                    MobilePageMsg.PreUpdate(MobilePageCase.P01_all())
                  ),
                  `class` := "font-bold"
                )("새로운 서비스를 준비중 이신가요?"),
                div("지금 견적 받기!")
              )
            )
          )
        ),
        div(
          `class` := " rounded-lg border border-white px-[10px] h-[105px] w-[340px] py-4 pb-6 bg-gray-600/30 hover:bg-green-600/20 cursor-pointer"
        )(
          div(`class` := "flex flex-col  ")(
            div(`class` := "text-base  ")(
              div(
                `class` := "flex justify-between"
              )(
                div(`class` := "flex justify-end space-x-2")(
                  img(
                    `class` := "w-[20px] h-[20px]",
                    src :=
                      "https://seeklogo.com/images/K/kakao-talk-logo-7542043DFC-seeklogo.com.png"
                  ),
                  div(
                    `class` := "flex flex-col h-[20px]  justify-center content-center"
                  )(
                    "전문가와 오픈톡"
                  )
                ),
                div(
                  `class` := "flex flex-col h-[20px]  justify-center content-center"
                )(
                  s"${Dom.timeAgo(model.time.getTime(), model.init_time.getTime())}"
                )
              ),
              div(
                `class` := "text-left py-2 ",
                onClick(
                  MobilePageMsg.PreUpdate(MobilePageCase.P02_all())
                )
              )(
                div(`class` := "font-bold")("아이디어는 있는데... 어떻게 해야할지 모르겠다면"),
                div("전문가와 커피챗 하기 >")
              )
            )
          )
        )
        // div(
        //   `class` := " rounded-lg border border-white px-[10px] h-[105px] w-[340px] py-4 pb-6 bg-gray-600/30 hover:bg-green-600/20 cursor-pointer"
        // )(
        //   div(`class` := "flex flex-col  ")(
        //     div(`class` := "text-base  ")(
        //       div(
        //         `class` := "flex justify-between"
        //       )(
        //         div(`class` := "flex justify-end space-x-2")(
        //           img(
        //             `class` := "w-[20px] h-[20px]",
        //             src :=
        //               "https://seeklogo.com/images/K/kakao-talk-logo-7542043DFC-seeklogo.com.png"
        //           ),
        //           div(
        //             `class` := "flex flex-col h-[20px]  justify-center content-center"
        //           )(
        //             "전문가와 오픈톡"
        //           )
        //         ),
        //         div(
        //           `class` := "flex flex-col h-[20px]  justify-center content-center"
        //         )(
        //           s"${Dom.timeAgo(model.time.getTime(), model.init_time.getTime())}"
        //         )
        //       ),
        //       a(
        //         `class` := "text-left py-2 ",
        //         href := "https://open.kakao.com/o/seBeGPuc",
        //         target := "_blank"
        //       )(
        //         div(`class` := "font-bold")("아이디어는 있는데... 어떻게 해야할지 모르겠다면"),
        //         div("전문가와 커피챗 하기 >")
        //       )
        //     )
        //   )
        // )
      )
    )

// def subscriptions(model: Model): Sub[IO, Msg] =
//     Sub.every[IO](1.second, "clock-ticks").map(Msg.Tick.apply)
