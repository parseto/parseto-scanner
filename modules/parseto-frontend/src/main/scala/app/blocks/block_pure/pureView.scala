package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object PureView:
  def actionButton(model: PureModel) = div(`class` := "flex justify-center")(
    span(
      onClick(PurePageMsg.PreUpdate(model.pointer - 1)),
      `class` := "cursor-pointer hover:bg-green-600/40"
    )(
      "Left action button"
    ),
    span(
      onClick(PurePageMsg.PreUpdate(model.pointer + 1)),
      `class` := "bg-red-50 rounded-[50%] w-[40px] h-[40px] bottom-[50px] left-[30px] absolute cursor-pointer hover:bg-green-600/40"
    )(
      "right action button"
    )
    // div(onClick(PurePageMsg.PreUpdate(model.pointer - 1)))("<"),
    // div(onClick(PurePageMsg.PreUpdate(model.pointer + 1)))(">")
  )

  def view(model: PureModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      {
        model.pointer match
          case 0 => _P0.view
          case 1 => _P01_all.view
          case 2 => _P01_medi.view
          case _ => _P0.view
      }.::(actionButton(model))
    )
