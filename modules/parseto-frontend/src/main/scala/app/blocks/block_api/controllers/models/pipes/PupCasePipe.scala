package parseto
import io.circe.Json
import app.parseto.common.function.logs.log2

object PupCasePipe:
  def get_url(pubCase: PubCase) =
    pubCase match
      case pub: PubCase.TxPub  => "http://localhost:3000/tx"
      case pub: PubCase.ApiPub => "http://localhost:3000/api"

  def updatePubCase_data(pub: PubCase, json: Json) =
    pub match
      case pub: PubCase.TxPub =>
        PubCase.TxPub(
          pub_m1 = json,
          pub_m2 = json.as[List[Transaction]].getOrElse(List(Transaction()))
        )
      case pub: PubCase.ApiPub =>
        log2("json")(json)
        PubCase.ApiPub(
          pub_m1 = json,
          pub_m2 = json
            .as[List[List[String]]]
            .getOrElse(List.empty)
            .map(list => ApiData(list(0), list(1), list(2), list(3), list(4)))
        )
