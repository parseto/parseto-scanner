package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P02_ALL:
  def genButtonCase(talkSectors: List[TalkSector])(d: TalkSector) =
    genButton(
      d.name,
      BizSectorPipe.css(d.isClick),
      BizSectorPipe.msg(d.name)
    )
  def genButton(str: String, css: String, msg: Msg) = button(
    `class` := css,
    onClick(msg)
  )(str)

  def main(talkSectors: List[TalkSector]) =
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")("전문가와 1:1 상담!"),
      div(`class` := "grid grid-cols-3 gap-4 text-sm text-gray-600")(
        talkSectors.map(genButtonCase(talkSectors))
      )
    )

  def view(model: ProdModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        main(model.talkSector),
        MobileFooterView.view(
          BizSectorPipe.cssFooter(
            model.bizSector.map(d => d.isClick).contains(true)
          )
        )
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
