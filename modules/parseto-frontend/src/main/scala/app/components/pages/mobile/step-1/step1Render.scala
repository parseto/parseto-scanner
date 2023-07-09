package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object Step1Render:

  def render(model: Model): Html[Msg] =
    model.bizSector.filter(d => d.isClick)(0).name match
      case "의료" =>
        List(
          div(
            `class` := Common.Css.layout
          )(
            MobileHeaderView.viewBack,
            div(
              `class` := "device-container"
            )(
              "의료"
            )
          ),
          Phone.view(model)(0)
        )(1)

      case str: String =>
        div(
          `class` := Common.Css.layout
        )(
          MobileHeaderView.viewBack,
          div(str)
        )
