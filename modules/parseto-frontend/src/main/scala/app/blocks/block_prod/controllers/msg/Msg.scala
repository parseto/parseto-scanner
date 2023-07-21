package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

enum MobilePageMsg extends Msg:
  case PreUpdate(page: MobilePageCase)
  case Next

enum BizSectorMsg extends Msg:
  case BizSectorUpdate(name: String)
  case BizSectorInit(bizs: List[BizSector])

enum TalkSectorMsg extends Msg:
  case TalkSectorUpdate(name: String)

enum ProfileSectorMsg extends Msg:
  case ProfileSectorUpdate(name: String)

enum SampleSectorMsg extends Msg:
  case SampleSectorUpdate(name: String)
  case SampleSectorReplace(sampleMap: Map[String, List[SampleSector]])

enum StepMsg extends Msg:
  case StepUpdate(step: Int)

enum RealTimeMsg extends Msg:
  case Tick(newTime: js.Date)
