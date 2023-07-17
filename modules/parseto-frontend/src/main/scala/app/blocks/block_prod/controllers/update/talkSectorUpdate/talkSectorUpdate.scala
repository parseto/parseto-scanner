package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object TalkSectorUpdate:
  def update(model: BlockModel): TalkSectorMsg => (BlockModel, Cmd[IO, Msg]) =
    case TalkSectorMsg.TalkSectorUpdate(name) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(talkSector =
            model.prodModel.talkSector
              .map(d =>
                d.name == name match
                  case true => d.copy(isClick = !d.isClick)
                  case _    => d.copy(isClick = false)
              )
          )
        ),
        Cmd.None
      )