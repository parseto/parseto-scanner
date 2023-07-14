package parseto
import tyrian.*
import cats.effect.IO

object ProdUpdate:
  def update(model: BlockModel): ProdMsg => (BlockModel, Cmd[IO, ProdMsg]) =
    case ProdMsg.PreUpdate => (model.copy(), Cmd.None)
