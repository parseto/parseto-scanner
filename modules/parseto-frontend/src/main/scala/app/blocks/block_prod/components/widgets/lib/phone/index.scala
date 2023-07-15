package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import app.parseto.common._api.*

object Phone:
  def view(model: ProdModel) =
    List(
      div(`class` := "galuxy-note-10")(
        b("Camera"),
        s("10:24"),
        iframe(
          `class` := "mySmartphone content rounded-lg",
          src := "https://wikipedia.org",
          style := "width:100%;border:none;height:100%;border-radius:20px"
        )(),
        span("Left action button"),
        span("Right action button")
      ),
      div(`class` := "iphone-x")(
        i("Speaker"),
        b("Camera"),
        s("10:24"),
        iframe(
          `class` := "mySmartphone content rounded-lg",
          src := "https://wikipedia.org",
          style := "width:100%;border:none;height:100%;"
        )(),
        span("Left action button"),
        span("Right action button")
      ),
      div(
      )(
        div(`class` := "device-container")(
          div(`class` := "mySmartphone")(
            div(`class` := "mySmarphone arrow-left")(),
            span(`class` := "hamburger")(),
            div(`class` := "mySmarphone nook")(),
            div(`class` := "mySmarphone myPower")(),
            div(`class` := "content")(
              iframe(
                `class` := "mySmartphone content",
                src := "https://wikipedia.org",
                style := "width:90%;border:none;height:90%;"
              )()
            )
          )
        )
      )
    )
