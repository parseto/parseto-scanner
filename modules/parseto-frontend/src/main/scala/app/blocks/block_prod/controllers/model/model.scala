package parseto
import tyrian.Html.*

import io.circe.Json
import scalajs.js

import tyrian.Html

final case class ProdModel(
    appStates: List[StateCase],
    pointer: Int,
    bizSector: List[BizSector],
    talkSector: List[TalkSector],
    profileSector: List[ProfileSector],
    step: Int = 0,
    time: scala.scalajs.js.Date = new js.Date(),
    init_time: scala.scalajs.js.Date = new js.Date()
    // mobilePageCase: MobilePageCase =
)
