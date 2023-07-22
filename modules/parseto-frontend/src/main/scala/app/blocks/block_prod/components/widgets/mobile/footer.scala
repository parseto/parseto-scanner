package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object MobileFooterView:
  def render(model: ProdModel)(css: String) =
    model.pipe(ModelPipe.find_current_PageCase) match
      case page: MobilePageCase.P021_all_dev =>
        button(
          onClick(MobilePageMsg.Next),
          `type` := "submit",
          `class` := css
        )(
          p("오픈프로필 연결"),
          p(`class` := "pl-2 font font-bold")(">")
        )
      case page: MobilePageCase.P01X_POST =>
        button(
          // onClick(MobilePageMsg.Post),
          // onSubmit(),
          `form` := "PO1X_POST",
          `type` := "button",
          `class` := css
        )(
          p("나만의 카테고리 생성하기!"),
          p(`class` := "pl-2 font font-bold")(">")
        )
      case _ =>
        button(
          onClick(MobilePageMsg.Next),
          `type` := "submit",
          `class` := css
        )(
          p("다음"),
          p(`class` := "pl-2 font font-bold")(">")
        )

  def view(css: String) =
    button(
      onClick(MobilePageMsg.Next),
      `type` := "submit",
      `class` := css
    )(
      p("다음"),
      p(`class` := "pl-2 font font-bold")(">")
    )
