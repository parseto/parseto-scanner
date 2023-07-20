package parseto
import io.circe.Json

object PupCasePipe:
  def get_url(pubCase: PubCase) =
    pubCase match
      case pub: PubCase.TxPub => "http://localhost:3000/tx"

  def updatePubCase_data(pub: PubCase, json: Json) =
    pub match
      case pub: PubCase.TxPub =>
        PubCase.TxPub(
          pub_m1 = json,
          pub_m2 = json.as[List[Transaction]].getOrElse(List(Transaction()))
        )
