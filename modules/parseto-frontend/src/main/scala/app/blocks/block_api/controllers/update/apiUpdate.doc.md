```scala
case class ApiPayload(page: String)

object UnderDataProcess:

  private def onResponse(pub: PubCase): Response => Msg = response =>
    import io.circe.*, io.circe.generic.semiauto.*
    parse(response.body) match
      case Left(parsingError) =>
        pub match
          case PubCase.TxDetailPub(hash, _, _) =>
          case _ => PageMsg.RolloBack

      case Right(json) =>
        PageMsg.DataUpdate(
          update_PubCase_data(pub, response.body),
        )

  private val onError: HttpError => Msg = e => PageMsg.BackObserver

  def fromHttpResponse(pub: PubCase): Decoder[Msg] =
    Decoder[Msg](onResponse(pub), onError)

object OnDataProcess:

  def getData(
      pub: PubCase,
      model: Model,
  ): Cmd[IO, Msg] =
    Http.send(
      Request.get(get_api_link(pub, model)).withTimeout(30.seconds),
      UnderDataProcess.fromHttpResponse(pub),
    )

```

```scala
object Transactionboard:

  def update(model: MainModel): Msg => (MainModel, Cmd[IO, Msg]) =
    case Msg.GetData(url) =>
      val cmd = getInitData(url)
      (model, cmd)

    case Msg.TxOk(v: List[Transaction]) =>
      (model.copy(transactions = v), Cmd.None)

    case Msg.Error(str) =>
      (model, Cmd.None)

    case _ => (model, Cmd.None)

  def getInitData(url: String): Cmd[IO, Msg] =
    Http.send(
      Request
        .get(url)
        .withTimeout(5.seconds),
      Decoder[Msg](
        parseJson,
        onError => Msg.Error("error :: http connect error")
      )
    )

  def parseJson(res: Response): Msg =
    parse(res.body) match
      case Left(_) => Msg.Error("Invalid json response")
      case Right(json) =>
        json.as[List[Transaction]] match
          case Right(v) => Msg.TxOk(v)
          case Left(_)  => Msg.Error("Invalid transaction data")

```

```scala


init
|> model,pub,
```
