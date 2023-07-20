package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.ModelPipe.find_current_PageCase

object Pages:
  def render(model: ProdModel, apiModel: ApiModel): Html[Msg] =
    find_current_PageCase(model) match
      case page: MobilePageCase.P0      => P0_IntroView.view(model)
      case page: MobilePageCase.P01_all => P01_all.view(model, apiModel)
      case page: MobilePageCase.P01x_matchSamples =>
        P01x_matchSamples.view(model)
      case page: MobilePageCase.P01xy            => P01xy.view(model)
      case page: MobilePageCase.P02_all          => P02_ALL.view(model)
      case page: MobilePageCase.P021_all_dev     => P021_all_dev.view(model)
      case page: MobilePageCase.P021x_linkedPage => P021x_linkedPage.view(model)

object MobileView:

  def layout() =
    div()

  def view(model: ProdModel, apiModel: ApiModel): Html[Msg] =
    Pages.render(model, apiModel)
