package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

trait Msg

enum CommonMsg extends Msg:
  case UpdateBlockPointer(blockPointer: Int)

enum ProdMsg extends Msg:
  case PreUpdate
