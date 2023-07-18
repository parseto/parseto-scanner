package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object P01xy:

  def view(model: ProdModel): Html[Msg] =
    div(`class` := "galuxy-note-10")(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        iframe(
          `class` := "mySmartphone content rounded-lg",
          // src := "https://wikipedia.org",
          src := model
            .sampleSectorMap(model.bizSector.filter(d => d.isClick)(0).name)
            .filter(d => d.isClick)(0)
            .url,
          style := "width:100%;border:none;height:100%;border-radius:20px"
        )()
      ),
      ActionButton.left(model),
      ActionButton.right(model)
    )
