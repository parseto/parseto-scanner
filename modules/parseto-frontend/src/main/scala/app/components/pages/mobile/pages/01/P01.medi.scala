package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P01_medi:

  def view(model: Model): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      // MobileHeaderView.view,
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        // MobileMainView.view(model.bizSector),
        h1("asdasd")
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )

  def render(model: Model)(page: String): Html[Msg] =
    page match
      case "intro" =>
        div(
          `class` := Common.Css.layout
        )(
          MobileHeaderView.view,
          MobileMainView.view(model.bizSector),
          MobileFooterView.view(
            BizSectorPipe.cssFooter(
              model.bizSector.map(d => d.isClick).contains(true)
            )
          )(model)
        )

      case "galuxy-note-10-display" =>
        div(`class` := "galuxy-note-10")(
          b("Camera"),
          s(
            Clock.view(model),
            Noti.view(model)
          ),
          ActionButton.left(model),
          ActionButton.right(model)
        )

      case "galuxy-note-10-intro" =>
        div(`class` := "galuxy-note-10")(
          b("Camera"),
          s("10:24"),
          iframe(
            `class` := "mySmartphone content rounded-lg",
            src := "https://wikipedia.org",
            style := "width:100%;border:none;height:100%;border-radius:20px"
          )(),
          span()("Left action button"),
          span()("Right action button")
        )

      case str: String =>
        div(
          `class` := Common.Css.layout
        )(
          MobileHeaderView.viewBack,
          div(str)
        )
