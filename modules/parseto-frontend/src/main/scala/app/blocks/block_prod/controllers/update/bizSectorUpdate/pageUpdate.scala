package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object BizSectorUpdate:
  def update(model: BlockModel): BizSectorMsg => (BlockModel, Cmd[IO, Msg]) =
    case BizSectorMsg.BizSectorUpdate(name) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(bizSector =
            model.prodModel.bizSector
              .map(d =>
                d.name == name match
                  case true => d.copy(isClick = !d.isClick)
                  case _    => d.copy(isClick = false)
              )
          )
        ),
        Cmd.None
      )
