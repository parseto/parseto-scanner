package parseto
import io.circe.Json
import scala.scalajs.js

object PupCasePipe:
  def get_url(pubCase: PubCase) =
    val base = js.Dynamic.global.process.env.API_LINK
    pubCase match
      case pub: PubCase.TxPub  => s"$base/api/tx/getTx"
      case pub: PubCase.ApiPub => s"$base/api/google/getData"

  def updatePubCase_data(pub: PubCase, json: Json) =
    pub match
      case pub: PubCase.TxPub =>
        PubCase.TxPub(
          pub_m1 = json,
          pub_m2 = json.as[List[Transaction]].getOrElse(List(Transaction()))
        )
      case pub: PubCase.ApiPub =>
        PubCase.ApiPub(
          pub_m1 = json,
          pub_m2 = json
            .as[List[List[String]]]
            .getOrElse(List.empty)
            // .pipe(log2("list??"))
            .map(list => ApiData(list(0), list(1), list(2), list(3), list(4)))
          // .pipe(log2("api data 111"))
        )
