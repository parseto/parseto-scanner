package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.ModelPipe.find_current_PageCase

object Pages:
  def render(model: Model): Html[Msg] =
    find_current_PageCase(model) match
      case page: MobilePageCase.P0       => P0_IntroView.view(model)
      case page: MobilePageCase.P01_all  => P01_all.view(model)
      case page: MobilePageCase.P01_medi => P01_medi.view(model)
      case page: MobilePageCase.P02      => div()

object MobileView:

  def layout() =
    div()

  def view(model: Model): Html[Msg] =
    Pages.render(model)

  def view2(model: Model): Html[Msg] =
    model.step match
      case 0 =>
        List(
          Step0Render.render(model)("galuxy-note-10-display"),
          Step0Render.render(model)("galuxy-note-10-intro"),
          Pages.render(model)
        )(2)

      case 1 => Step1Render.render(model)
