package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log
import app.parseto.common.function.logs.log2

object RealTimeUpdate:
  def update(model: BlockModel): RealTimeMsg => (BlockModel, Cmd[IO, Msg]) =
    case RealTimeMsg.Tick(time: js.Date) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(time = time)
        ),
        Cmd.None
      )
