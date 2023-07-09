package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import cats.instances.boolean
import app.parseto.common.function.logs.log2

object MobileMainView:

  def clickHandle = ???
  // name

  def genButton(str: String, css: String, msg: Msg) = button(
    `class` := css,
    onClick(msg)
  )(str)

  def genButtonCase(bizSectors: List[BizSector])(d: BizSector) =
    log2("d")(d.isClick)
    genButton(
      d.name,
      BizSectorPipe.css(d.isClick),
      BizSectorPipe.msg(d.name)
    )

  def view(bizSectors: List[BizSector]) =
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")("어떤 업종을 운영하시나요?"),
      div(`class` := "grid grid-cols-3 gap-4 text-sm text-gray-600")(
        bizSectors.map(genButtonCase(bizSectors))
      )
    )
