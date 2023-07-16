package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object ProfileSectorUpdate:
  def update(
      model: BlockModel
  ): ProfileSectorMsg => (BlockModel, Cmd[IO, Msg]) =
    case ProfileSectorMsg.ProfileSectorUpdate(name) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(profileSector =
            model.prodModel.profileSector
              .map(d =>
                d.name == name match
                  case true => d.copy(isClick = !d.isClick)
                  case _    => d.copy(isClick = false)
              )
          )
        ),
        Cmd.None
      )
