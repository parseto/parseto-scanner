package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P02_P1:

  def view(model: ProdModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        iframe(
          `class` := "mySmartphone content rounded-lg",
          // src := "https://wikipedia.org",
          src := "https://open.kakao.com/o/seBeGPuc",
          style := "width:100%;border:none;height:100%;border-radius:20px"
        )()
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
