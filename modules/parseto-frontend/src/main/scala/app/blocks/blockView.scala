package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import app.parseto.common.function.logs.log2

object BlockView:

  def view(model: BlockModel): Html[Msg] =
    log2("안녕")("model.prodModel")
    div(
    )(
      div(`class` := "flex bg-red-50 justify-between w-[100px]")(
        div(onClick(CommonMsg.UpdateBlockPointer(0)))("1"),
        div(onClick(CommonMsg.UpdateBlockPointer(1)))("2"),
        div(onClick(CommonMsg.UpdateBlockPointer(2)))("3")
      ),
      div(
      )(
        // List(div("11"), div("2"), div()("3"))(
        //   model.blockPointer
        // )
        List(PageView.view(model.prodModel), div("2"), div()("3"))(
          model.blockPointer
        )
        // List(div("2"), div("2"), div()("3"))(
        //   model.blockPointer
        // )
      )
    )
