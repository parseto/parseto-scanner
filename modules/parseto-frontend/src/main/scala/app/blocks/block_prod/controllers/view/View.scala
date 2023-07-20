package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import app.parseto.common._api.*

object ProdView:
  def view(prodmodel: ProdModel, apiModel: ApiModel): Html[Msg] =
    PageView.view(prodmodel, apiModel)
