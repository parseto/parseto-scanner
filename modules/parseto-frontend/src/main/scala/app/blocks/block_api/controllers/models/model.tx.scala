package parseto

import io.circe.*
import io.circe.generic.semiauto.*
import io.circe.parser.*

case class Transaction(
    address: String,
    amount: Float
):
  override def toString = s"${this.address} ${this.amount}"

object Transaction:
  def apply(): Transaction =
    Transaction(
      address = "",
      amount = 0.0f
    )
  given Decoder[Transaction] = deriveDecoder[Transaction]
  given Encoder[Transaction] = deriveEncoder[Transaction]

  def decodeParser(data: String) = decode[List[Transaction]](data)

case class ApiData(
    name: String,
    page: String,
    isClick: String,
    url: String,
    category: String
):
  override def toString = s"${this.name} ${this.page}"

object ApiData:
  def apply(): ApiData =
    ApiData(
      name = "",
      page = "",
      isClick = "",
      url = "",
      category = ""
    )
  given Decoder[ApiData] = deriveDecoder[ApiData]
  given Encoder[ApiData] = deriveEncoder[ApiData]

  def decodeParser(data: String) = decode[List[ApiData]](data)
