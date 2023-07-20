package parseto
import tyrian.*
import cats.effect.IO

object CommonUpdate:
  def update(model: BlockModel): CommonMsg => (BlockModel, Cmd[IO, CommonMsg]) =
    case CommonMsg.UpdateBlockPointer(blockPointer) =>
      blockPointer match
        case 2 =>
          (
            model.copy(blockPointer = blockPointer),
            Cmd.None
          )
        case _ => (model.copy(blockPointer = blockPointer), Cmd.None)
