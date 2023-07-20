package parseto
import tyrian.Html.*

import io.circe.Json
import scalajs.js

import tyrian.Html

final case class ApiModel(
    appStates: List[ApiModelStateCase] = List(ApiModelStateCase()),
    pointer: Int = 1,
    txs: List[Transaction] = List(Transaction()),
    bizSector: List[BizSector] = BizSectorInit.value
)

case class ApiModelStateCase(
    apiModelPageCase: ApiModelPageCase = ApiModelPageCase.DashBoard(),
    number: Int = 1
)

enum ApiModelPageCase:
  case DashBoard(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 0, 1),
      pubs: List[PubCase] = List(
        PubCase.TxPub(),
        PubCase.ApiPub()
      )
  ) extends ApiModelPageCase
