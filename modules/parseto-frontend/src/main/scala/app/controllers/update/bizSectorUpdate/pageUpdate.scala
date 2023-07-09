package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO

object BizSectorUpdate:
  def update(model: Model): BizSectorMsg => (Model, Cmd[IO, Msg]) =
    case BizSectorMsg.BizSectorUpdate(list: List[BizSector]) =>
      (
        model.copy(
          bizSector = list
        ),
        Cmd.None
      )
