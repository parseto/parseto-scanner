package parseto
import scala.util.chaining.*
import scala.scalajs.js
import parseto.PageCasePipe.*
import parseto.StateCasePipe.*

object ApiModelPipe:
  def in_appStates(model: ApiModel) =
    model.appStates

  def find_current_PageCase(model: ApiModel) =
    model
      .pipe(in_appStates)
      .pipe(ApiModelStateCasePipe.find_PageCase(model.pointer))

  def get_latest_number(model: ApiModel): Int =
    model
      .pipe(in_appStates)
      .pipe(ApiModelStateCasePipe.find_latest_Number)
