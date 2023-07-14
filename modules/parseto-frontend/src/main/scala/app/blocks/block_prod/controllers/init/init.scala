package parseto
import tyrian.*
import cats.effect.IO

object Init:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (
      Model(
        appStates = List(
          StateCase(
            mobilePageCase = MobilePageCase.P0(),
            number = 1
          )
        ),
        pointer = 1,
        bizSector = BizSectorInit.value
      ),
      Cmd.None
    )
