package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.Log.log2

object P01X_GET:

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

  def main(profileSectors: List[SampleSector]) =
    log2("profileSectors==")(profileSectors)
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")("업종 샘플"),
      div(`class` := "grid grid-cols-1 gap-4 text-sm text-gray-600")(
        profileSectors.map(genButtonCase(profileSectors))
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
          model.sampleSectorMap(
            name
          )
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
