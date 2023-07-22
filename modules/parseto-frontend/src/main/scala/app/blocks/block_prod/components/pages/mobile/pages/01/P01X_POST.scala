package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.Log.log2

object P01X_POST:

  def genButtonCase(profileSectors: List[SampleSector])(d: SampleSector) =
    genButton(
      d.name,
      SampleSectorPipe.css(d.isClick),
      SampleSectorPipe.msg(d.name)
    )
  def genButton(str: String, css: String, msg: Msg) = button(
    `class` := css,
    onClick(msg)
  )(str)

  def main() =
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")("새로운 업종 추가하기"),
      // consider .. (POST 요청을 msg 단에서 처리하는것이 좋을지 고민)
      form(
        `class` := "",
        id := "PO1X_POST",
        method := "post",
        action := "http://localhost:3000/api/google/postData",
        target := "_self"
      )(
        div(`class` := "grid gap-6 mb-6 ")(
          div(
            label(
              `for` := "category",
              `class` := "block mb-2 text-sm font-medium text-gray-900 "
            )("카테고리"),
            input(
              `type` := "text",
              id := "category",
              name := "category",
              `class` := "bg-gray-100 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ",
              placeholder := "웹서비스",
              required
            )
          ),
          div(
            label(
              `for` := "website",
              `class` := "block mb-2 text-sm font-medium text-gray-900 "
            )("Website URL"),
            input(
              `type` := "url",
              id := "website",
              name := "website",
              `class` := "bg-gray-100 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ",
              placeholder := "flowbite.com",
              required
            )
          )
        )
      )
    )

  def view(model: ProdModel): Html[Msg] =
    val name = model.bizSector.filter(d => d.isClick)(0).name

    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        main(
        ),
        MobileFooterView.render(model)(
          SampleSectorPipe.cssFooter(
            model
              .sampleSectorMap(name)
              .map(d => d.isClick)
              .contains(true)
          )
        )
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
