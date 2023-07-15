package parseto
import tyrian.*
import cats.effect.IO

object BlockUpdate:
  def update(model: BlockModel): Msg => (BlockModel, Cmd[IO, Msg]) =
    case commonMsg: CommonMsg   => CommonUpdate.update(model)(commonMsg)
    case pageMsg: MobilePageMsg => PageUpdate.update(model)(pageMsg)

    case bizSectorMsg: BizSectorMsg =>
      BizSectorUpdate.update(model)(bizSectorMsg)

    case stepMsg: StepMsg =>
      StepUpdate.update(model)(stepMsg)

    case tickMsg: RealTimeMsg =>
      RealTimeUpdate.update(model)(tickMsg)

    case purePageMsg: PurePageMsg =>
      PureModelUpdate.update(model)(purePageMsg)

    // case blockMsg: ProdMsg    => BlockUpdate.update(model)(blockMsg)
