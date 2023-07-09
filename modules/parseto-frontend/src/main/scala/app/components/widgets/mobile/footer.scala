package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MobileFooterView:

  def view(css: String)(model: Model) =
    button(
      // onClick(StepMsg.StepUpdate(1)),
      onClick(
        MobilePageMsg.PreUpdate(model.bizSector.filter(d => d.isClick)(0).page)
      ),
      `type` := "submit",
      `class` := css
    )(
      p("다음"),
      p(`class` := "pl-2 font font-bold")(">")
    )

  // def render(model: Model) = model.step match
  //   case 0 => (css: String) => view(css)
  //   case 1 => (css: String) => div()
