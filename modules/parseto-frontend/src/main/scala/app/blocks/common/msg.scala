package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

trait Msg
enum CommonMsg extends Msg:
  case UpdateBlockPointer(blockPointer: Int)

// trait Msg

// object Msg:
//   trait CommonMsg extends Msg

//   object CommonMsg:
//     case class UpdateBlockPointer(blockPointer: Int)

// enum ProdMsg extends Msg:
//   case PreUpdate

// sealed trait Transaction:

// object Transaction:
//   sealed trait AccountTx extends Transaction:
//   object AccountTx:
//     final case class CreateAccount(
