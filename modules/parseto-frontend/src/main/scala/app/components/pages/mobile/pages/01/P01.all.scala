package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P01_all:

  def view(model: Model): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        MobileMainView.view(model.bizSector),
        MobileFooterView.view(
          BizSectorPipe.cssFooter(
            model.bizSector.map(d => d.isClick).contains(true)
          )
        )(model)
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
