package parseto
import io.circe.parser.*
import io.circe.Json

enum PubCase:
  case TxPub(
      pub_m1: Json = Json.fromString("null"),
      pub_m2: List[Transaction] = List(Transaction())
  ) extends PubCase
