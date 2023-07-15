package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object PureView:

  def view(model: PureModel): Html[Msg] =
    div()(
      div()(
        div(onClick(PurePageMsg.PreUpdate(model.pointer - 1)))("<"),
        div(onClick(PurePageMsg.PreUpdate(model.pointer + 1)))(">")
      ),
      model.pointer match
        case 0 => _P0.view
        case 1 => _P01_all.view
        case 2 => _P01_medi.view
        case _ => _P0.view
    )
