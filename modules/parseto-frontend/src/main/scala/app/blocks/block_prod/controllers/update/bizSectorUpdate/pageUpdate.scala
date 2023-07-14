package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object BizSectorUpdate:
  def update(model: Model): BizSectorMsg => (Model, Cmd[IO, Msg]) =
    case BizSectorMsg.BizSectorUpdate(name) =>
      log2("hi")(name)
      (
        model.copy(
          bizSector = model.bizSector
            .map(d =>
              d.name == name match
                case true => d.copy(isClick = !d.isClick)
                case _    => d.copy(isClick = false)
            )
            .pipe(log2("업데이트된이휴"))
        ),
        Cmd.None
      )
