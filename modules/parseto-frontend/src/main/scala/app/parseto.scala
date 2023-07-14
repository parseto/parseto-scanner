package parseto

import cats.effect.IO
import tyrian.Html.*
import tyrian.*

import scala.scalajs.js.annotation.*

@JSExportTopLevel("TyrianApp")
object Parseto extends TyrianApp[Msg, BlockModel]:

  def init(flags: Map[String, String]): (BlockModel, Cmd[IO, Msg]) =
    BlockInit.init(flags)

  def update(model: BlockModel): Msg => (BlockModel, Cmd[IO, Msg]) =
    BlockUpdate.update(model)

  def view(model: BlockModel): Html[Msg] =
    BlockView.view(model)

  def subscriptions(model: BlockModel): Sub[IO, Msg] =
    BlockSubscriptions.subscriptions(model)
