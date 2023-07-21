package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.Log.log2

object P01_all:

  def view(model: ProdModel, apiModel: ApiModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        MobileMainView.view({
          model.bizSector
        }),
        MobileFooterView.view(
          BizSectorPipe.cssFooter(
            model.bizSector.map(d => d.isClick).contains(true)
          )
        )
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
