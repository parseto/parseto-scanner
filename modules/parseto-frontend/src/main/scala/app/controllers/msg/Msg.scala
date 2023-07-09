package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

sealed trait Msg

enum MobilePageMsg extends Msg:
  case PreUpdate(page: MobilePageCase)

enum BizSectorMsg extends Msg:
  case BizSectorUpdate(list: List[BizSector])

enum StepMsg extends Msg:
  case StepUpdate(step: Int)

enum RealTimeMsg extends Msg:
  case Tick(newTime: js.Date)
