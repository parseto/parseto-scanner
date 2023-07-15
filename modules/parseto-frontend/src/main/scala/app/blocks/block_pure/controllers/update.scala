package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object PureModelUpdate:
  def update(model: BlockModel): PurePageMsg => (BlockModel, Cmd[IO, Msg]) =
    case PurePageMsg.PreUpdate(pointer: Int) =>
      var _pointer = pointer < 0 match
        case true => 0
        case _    => pointer

      (
        model.copy(
          pureModel = model.pureModel.copy(pointer = _pointer)
        ),
        Cmd.None
      )
