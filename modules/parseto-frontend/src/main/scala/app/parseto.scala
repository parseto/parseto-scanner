package parseto

import cats.effect.IO
import tyrian.Html.*
import tyrian.*

import scala.scalajs.js.annotation.*

@JSExportTopLevel("TyrianApp")
object Parseto extends TyrianApp[Msg, Model]:

  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    Init.init(flags)

  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    Update.update(model)

  def view(model: Model): Html[Msg] =
    View.view(model)

  def subscriptions(model: Model): Sub[IO, Msg] =
    Subscriptions.subscriptions(model)
