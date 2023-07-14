package parseto
import tyrian.*
import cats.effect.IO

object BlockUpdate:
  def update(model: BlockModel): Msg => (BlockModel, Cmd[IO, Msg]) =
    case commonMsg: CommonMsg => CommonUpdate.update(model)(commonMsg)
    case blockMsg: ProdMsg    => BlockUpdate.update(model)(blockMsg)
