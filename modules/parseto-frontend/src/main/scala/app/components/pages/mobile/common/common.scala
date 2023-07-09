package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object Common:
  object Css:
    val layout =
      "flex flex-col justify-between border border-gray-600 rounded p-3 w-[400px] h-[730px]"
