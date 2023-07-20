package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import app.parseto.common.function.logs.log2

object BlockView:

  def view(model: BlockModel): Html[Msg] =
    div(
      `class` := "pt-10"
    )(
      div(`class` := "flex bg-red-50 justify-between w-[100px]")(
        div(onClick(CommonMsg.UpdateBlockPointer(0)))("1"),
        div(onClick(CommonMsg.UpdateBlockPointer(1)))("2"),
        div(onClick(CommonMsg.UpdateBlockPointer(2)))("3"),
        div(onClick(CommonMsg.UpdateBlockPointer(2)))("4")
      ),
      div(
      )(
        model.blockPointer match
          case 0 =>
            PageView.view(model.prodModel, model.apiModel)
          case 1 =>
            PureView.view(model.pureModel)
            ApiPageView.view(model.apiModel)
          case 3 =>
            ApiPageView.view(model.apiModel)
          case _ =>
            ClonePageView.view(model.cloneModel)
      )
    )
