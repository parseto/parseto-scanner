package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.Log.log2

object P01x_matchSamples:

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

  def main(profileSectors: List[SampleSector], name: String) =
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")(s"${name} 업종 샘플"),
      div(`class` := "grid grid-cols-1 gap-4 text-sm text-gray-600")(
        profileSectors.map(genButtonCase(profileSectors))
      )
    )

  def view(model: ProdModel): Html[Msg] =
    val name = model.bizSector.filter(d => d.isClick)(0).name match
      case "의료" => "의료"
      case _    => "랜덤"

    log2("name")(model.bizSector.filter(d => d.isClick)(0).name)
    // val name = "medi"
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        // bizsector => true 인거 => bizname
        // Map(bizname => bizSamples)(bizname)
        // bizSamples =>
        main(
          model.sampleSectorMap(name),
          name
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
