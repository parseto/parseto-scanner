package parseto
import scala.util.chaining.*
import scala.scalajs.js

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

  def find_last_PageCase(model: ApiModel) =
    model
      .pipe(in_appStates)
      .pipe(ApiModelStateCasePipe.find_PageCase(model.appStates.length))

  // def current_ViewCase(model: Model): ViewCase =
  //   model
  //     .pipe(find_current_PageCase)
  //     .pipe(pipe_ViewCase)
