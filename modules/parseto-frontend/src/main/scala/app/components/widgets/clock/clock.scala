package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import tyrian.SVG.*
import tyrian.*
import scala.util.chaining.*
import scala.scalajs.js.annotation.*

import scalajs.js
import concurrent.duration.DurationInt
import app.parseto.common.function.logs.log2

object Clock:
  def view(model: Model) =
    List(
      {
        // val angle = model.time.getSeconds() * 2 * math.Pi / 60 - math.Pi / 2
        // val handX = 50 + 40 * math.cos(angle)
        // val handY = 50 + 40 * math.sin(angle)

        // svg(viewBox := "0, 0, 100, 100", width := "300px")(
        //   circle(
        //     cx := "50",
        //     cy := "50",
        //     r := "45",
        //     fill := "#0B79CE"
        //   ),
        //   line(
        //     x1 := "50",
        //     y1 := "50",
        //     x2 := handX.toString,
        //     y2 := handY.toString,
        //     stroke := "#023963"
        //   )
        // )
        div("12:15")

      }, {

        var initTime = new js.Date().getTime()
        // :: ${Dom
        // .timeAgo(new js.Date().getTime(), model.time.getTime())

        var hr = model.time.getHours();
        var min = model.time.getMinutes();
        hr = hr match
          case 0 => 12
          case _ => hr
        hr = (hr > 12) match
          case true  => hr - 12
          case false => hr

        def timeFixer(m: Double): String = m < 10 match
          case true  => s"0$m"
          case false => s"$m"

        div(s"$hr : ${min.pipe(timeFixer)}")

      }
    )(1)

// def subscriptions(model: Model): Sub[IO, Msg] =
//     Sub.every[IO](1.second, "clock-ticks").map(Msg.Tick.apply)
