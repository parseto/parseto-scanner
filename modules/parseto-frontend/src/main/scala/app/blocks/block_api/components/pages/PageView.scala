package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*
import parseto.Log.log2

object ApiPageView:

  def view(model: ApiModel): Html[Msg] =
    div(
      `class` := s"flex justify-center"
    )(
      div(onClick(ApiMsg.PreUpdate(ApiModelPageCase.DashBoard())))(
        "tx 가져오기 버튼"
      ),
      div(onClick(ApiMsg.PreUpdate(ApiModelPageCase.DashBoard())))(
        "api 가져오기 버튼"
      ),
      div(model.txs.map(d => div(d.toString()))),
      div(
        model
          .pipe(ApiModelPipe.find_current_PageCase)
          .pipe(ApiPageCasePipe.pipe_PageResponseViewCase)
          .txs
          .map(d => div(s"${d}"))
      ),
      div(
        model
          .pipe(ApiModelPipe.find_current_PageCase)
          .pipe(ApiPageCasePipe.pipe_PageResponseViewCase)
          .apiData
          .map(d => div(s"${d}"))
      )
    )
