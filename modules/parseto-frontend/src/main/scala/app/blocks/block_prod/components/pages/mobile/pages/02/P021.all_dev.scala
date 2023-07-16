package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P021_all_dev:
  def genButtonCase(profileSectors: List[ProfileSector])(d: ProfileSector) =
    genButton(
      d.name,
      ProfileSectorPipe.css(d.isClick),
      ProfileSectorPipe.msg(d.name)
    )
  def genButton(str: String, css: String, msg: Msg) = button(
    `class` := css,
    onClick(msg)
  )(str)

  // https://open.kakao.com/o/seBeGPuc
  def main(profileSectors: List[ProfileSector]) =
    div(`class` := "flex flex-col gap-4 p-8 px-14 pt-20")(
      div(`class` := "text-lg font-bold")("1:1 오픈 카카오 프로필"),
      div(`class` := "grid grid-cols-1 gap-4 text-sm text-gray-600")(
        profileSectors.map(genButtonCase(profileSectors))
      )
    )

  def view(model: ProdModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        main(model.profileSector),
        MobileFooterView.render(model)(
          ProfileSectorPipe.cssFooter(
            model.profileSector.map(d => d.isClick).contains(true)
          )
        )
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
