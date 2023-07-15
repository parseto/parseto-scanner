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
        List(
          PageView.view(model.prodModel),
          PureView.view(model.pureModel),
          div()("3")
        )(
          model.blockPointer
        )
      )
    )
