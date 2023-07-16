package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object _P01_medi:
  def view =
    // div(`class` := "galuxy-note-10")(
    List(
      b("Camera"),
      div(
        `class` := "flex flex-col justify-between h-[100%] bg-white rounded-[20px]"
      )(
        iframe(
          `class` := "mySmartphone content rounded-lg",
          src := "https://clinicmarket.goodoc.co.kr/",
          style := "width:100%;border:none;height:100%;border-radius:20px"
        )()
      )
    )
