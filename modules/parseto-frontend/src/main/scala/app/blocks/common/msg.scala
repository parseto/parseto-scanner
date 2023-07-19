package parseto

import io.circe.Json
import org.scalajs.dom.Element
import scalajs.js

trait Msg
enum CommonMsg extends Msg:
  case UpdateBlockPointer(blockPointer: Int)

enum ApiMsg extends Msg:
  case GetData(url: String)

  case Error(url: String)

  case OkTx(v: List[Transaction])
  case PubTxs(data: Json)

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
