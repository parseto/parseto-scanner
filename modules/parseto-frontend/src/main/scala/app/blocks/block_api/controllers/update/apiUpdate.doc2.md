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

  def httpPipe(url: String): Cmd[IO, Msg] =
    Http.send(
      Request
        .get(url)
        .withTimeout(5.seconds),
      Decoder[Msg](
        ResponsePipe.onResponse(),
        ResponsePipe.onError
      )
    )

  //

  pubCase,model => url
  |>

  object PipeCmd:
    def httpConnect(url: String): Cmd[IO, Msg] =
    Http.send(
      Request
        .get(url)
        .withTimeout(5.seconds),
      Decoder[Msg](
        parseJson,
        onError => Msg.Error("error :: http connect error")
      )
    )

    def getUrl(pubCase) : url

  object PipeMsg:
    def onError = onError => Msg.Error("error :: http connect error")
    def onResponseTx(res: Response): Msg =
      parse(res.body) match
        case Left(_) => Msg.Error("Invalid json response")
        case Right(json) =>
          json.as[List[Transaction]] match
            case Right(v) => Msg.TxOk(v)
            case Left(_)  => Msg.Error("Invalid transaction data")

    def han



```

```scala


init
|> model,pub,
```
