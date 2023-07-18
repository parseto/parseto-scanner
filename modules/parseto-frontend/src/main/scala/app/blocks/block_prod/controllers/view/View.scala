package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import app.parseto.common._api.*

object ProdView:
  def view(model: ProdModel): Html[Msg] =
    PageView.view(model)
