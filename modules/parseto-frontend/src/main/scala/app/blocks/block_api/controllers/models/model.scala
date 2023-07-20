package parseto
import tyrian.Html.*

import io.circe.Json
import scalajs.js

import tyrian.Html

final case class ApiModel(
    appStates: List[ApiModelStateCase] = List(ApiModelStateCase()),
    pointer: Int = 0,
    txs: List[Transaction] = List(Transaction())
)

case class ApiModelStateCase(
    apiModelPageCase: ApiModelPageCase = ApiModelPageCase.DashBoard(),
    number: Int = 0
)

enum ApiModelPageCase:
  case DashBoard(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 0, 1),
      pubs: List[PubCase] = List(PubCase.TxPub())
  ) extends ApiModelPageCase