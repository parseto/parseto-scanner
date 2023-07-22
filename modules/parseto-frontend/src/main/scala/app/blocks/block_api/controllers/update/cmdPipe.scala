package parseto
import cats.effect.IO
import tyrian.Html.*
import tyrian.*
import tyrian.http.*
import scala.concurrent.duration.*
import io.circe.parser.*
import scala.util.chaining.*

object CmdPipe:
  private def responseOk(pub: PubCase): Response => ApiMsg = response =>
    import io.circe.*, io.circe.generic.semiauto.*
    parse(response.body) match
      case Left(_) => ApiMsg.Error("Invalid json response")

      case Right(json) =>
        ApiMsg.Update(PupCasePipe.updatePubCase_data(pub, json))

  private val responseError: HttpError => ApiMsg = e =>
    ApiMsg.Error("api connect error")

  def getDataCmd(pub: PubCase, model: BlockModel): Cmd[IO, ApiMsg] =
    Http.send(
      Request
        .get(PupCasePipe.get_url(pub))
        .withTimeout(5.seconds),
      Decoder[ApiMsg](responseOk(pub), responseError)
    )

  def postDataCmd(url: String): Cmd[IO, ApiMsg] =
    val sample = SampleSector(name = "sample", category = "category1")
    def sampleSectorToStringList(samples: List[SampleSector]) =
      val map = samples.map(d =>
        s"""["${sample.name}","${sample.page}","${sample.isClick}","${sample.url}","${sample.category}"]"""
      )

      s"[${map.mkString}]"

    Http.send(
      Request
        .post(
          url,
          Body.json(
            sampleSectorToStringList(List(sample)).pipe(Log.log2("send data"))
          )
        )
        .withTimeout(5.seconds),
      // .withHeaders(List(Header("Access-Control-Allow-Origin", "*"))),

      Decoder[ApiMsg](response => ApiMsg.None, responseError)
    )
