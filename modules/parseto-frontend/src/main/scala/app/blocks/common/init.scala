package parseto
import tyrian.*
import cats.effect.IO

object BlockInit:
  def init(flags: Map[String, String]): (BlockModel, Cmd[IO, Msg]) =
    (
      BlockModel(
        blockPointer = 0,
        prodModel = ProdModel(
          appStates = List(
            StateCase(
              mobilePageCase = MobilePageCase.P0(),
              number = 1
            )
          ),
          pointer = 1,
          bizSector = BizSectorInit.value
        )
      ),
      Cmd.None
    )
