package app
import scala.util.chaining.*
import scala.scalajs.js
import app.PageCasePipe.*
import app.StateCasePipe.*
// import io.leisuremeta.chain.lmscan.frontend.PupCasePipe.*
// import io.leisuremeta.chain.lmscan.frontend.PageCasePipe.*
// import io.leisuremeta.chain.lmscan.frontend.StateCasePipe.*

object ModelPipe:
  def in_appStates(model: Model) =
    model.appStates

  def find_current_PageCase(model: Model) =
    model
      .pipe(in_appStates)
      .pipe(find_PageCase(model.pointer))

  def find_name(model: Model) =
    model
      .pipe(find_current_PageCase)
      .pipe(in_Name)

  // def in_pointer(model: Model) =
  //   model.pointer

  // def find_curent_State(model: Model) =
  //   model.appStates
  //     .pipe(find_State(model.pointer))

  // def find_current_PubPage(model: Model) =
  //   model
  //     .pipe(find_curent_State)
  //     .pipe(in_pageCase)
  //     .pipe(in_PubCases)(0) // 0 => find
  //     .pipe(in_Page)

  // def find_current_PageCase(model: Model) =
  //   model
  //     .pipe(in_appStates)
  //     .pipe(find_PageCase(model.pointer))

  // def find_last_PageCase(model: Model) =
  //   model
  //     .pipe(in_appStates)
  //     .pipe(find_PageCase(model.appStates.length))

  // def find_tx_curpage(model: Model) =
  //   model
  //     .pipe(find_current_PageCase)
  //     .pipe(in_PubCases)
  //     .pipe(filter_txPub)(0)
  //     .pipe(in_Page)

  // def find_name(model: Model) =
  //   model
  //     .pipe(find_current_PageCase)
  //     .pipe(in_Name)

  // def current_ViewCase(model: Model): ViewCase =
  //   model
  //     .pipe(find_current_PageCase)
  //     .pipe(pipe_ViewCase)

  // def find_ViewCase(find: Int)(model: Model): ViewCase =
  //   model
  //     .pipe(in_appStates)
  //     .pipe(find_PageCase(find))
  //     .pipe(pipe_ViewCase)

  // def get_PageResponseViewCase(model: Model): PageResponseViewCase =
  //   model
  //     .pipe(find_current_PageCase)
  //     .pipe(pipe_PageResponseViewCase)

  def get_latest_number(model: Model): Int =
    model
      .pipe(in_appStates)
      .pipe(StateCasePipe.find_latest_Number)
