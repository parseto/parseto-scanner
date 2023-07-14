package parseto
import tyrian.*
import cats.effect.IO

object CommonUpdate:
  def update(model: BlockModel): CommonMsg => (BlockModel, Cmd[IO, CommonMsg]) =
    case CommonMsg.UpdateBlockPointer(blockPointer) =>
      (model.copy(blockPointer = blockPointer), Cmd.None)
