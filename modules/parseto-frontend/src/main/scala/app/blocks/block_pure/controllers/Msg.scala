package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

enum PurePageMsg extends Msg:
  case PreUpdate(pointer: Int)
