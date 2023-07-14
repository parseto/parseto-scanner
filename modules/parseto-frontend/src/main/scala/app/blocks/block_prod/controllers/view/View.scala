package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import app.parseto.common._api.*

object ProdView:
  def view(model: Model): Html[Msg] =
    List(
      div(
        PageView.view(model)
      ),
      Clock.view(model)
    )(0)
