package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.ModelPipe.*

object ActionButton:
  def left(model: ProdModel) =
    span(
      `class` := "cursor-pointer hover:bg-green-600/40",
      onClick(
        MobilePageMsg.PreUpdate(
          MobilePageCaseMap(
            model
              .pipe(find_current_PageCase)
              .pipe(ProdPageCasePipe.in_actionButton)
              .prev
          )
        )
      )
    )(
      "Left action button "
    )
  def right(model: ProdModel) =
    span(
      `class` := "cursor-pointer hover:bg-green-600/40",
      onClick(
        MobilePageMsg.PreUpdate(
          MobilePageCaseMap(
            model
              .pipe(find_current_PageCase)
              .pipe(ProdPageCasePipe.in_actionButton)
              .next
          )
        )
      )
    )(
      "right action button "
    )
