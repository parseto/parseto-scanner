package parseto
import scala.util.chaining.*
import scala.scalajs.js
import parseto.PageCasePipe.*
import parseto.StateCasePipe.*

object ModelPipe:
  def in_appStates(model: ProdModel) =
    model.appStates

  def find_current_PageCase(model: ProdModel) =
    model
      .pipe(in_appStates)
      .pipe(find_PageCase(model.pointer))

// // def find_name(model: ProdModel) =
// //   model
// //     .pipe(find_current_PageCase)
// //     .pipe(in_Name)

// // def in_pointer(model: ProdModel) =
// //   model.pointer

// // def find_curent_State(model: ProdModel) =
// //   model.appStates
// //     .pipe(find_State(model.pointer))

// // def find_current_PubPage(model: ProdModel) =
// //   model
// //     .pipe(find_curent_State)
// //     .pipe(in_pageCase)
// //     .pipe(in_PubCases)(0) // 0 => find
// //     .pipe(in_Page)

// // def find_current_PageCase(model: ProdModel) =
// //   model
// //     .pipe(in_appStates)
// //     .pipe(find_PageCase(model.pointer))

// // def find_last_PageCase(model: ProdModel) =
// //   model
// //     .pipe(in_appStates)
// //     .pipe(find_PageCase(model.appStates.length))

// // def find_tx_curpage(model: ProdModel) =
// //   model
// //     .pipe(find_current_PageCase)
// //     .pipe(in_PubCases)
// //     .pipe(filter_txPub)(0)
// //     .pipe(in_Page)

// // def find_name(model: ProdModel) =
// //   model
// //     .pipe(find_current_PageCase)
// //     .pipe(in_Name)

// // def current_ViewCase(model: ProdModel): ViewCase =
// //   model
// //     .pipe(find_current_PageCase)
// //     .pipe(pipe_ViewCase)

// // def find_ViewCase(find: Int)(model: ProdModel): ViewCase =
// //   model
// //     .pipe(in_appStates)
// //     .pipe(find_PageCase(find))
// //     .pipe(pipe_ViewCase)

// // def get_PageResponseViewCase(model: ProdModel): PageResponseViewCase =
// //   model
// //     .pipe(find_current_PageCase)
// //     .pipe(pipe_PageResponseViewCase)

  def get_latest_number(model: ProdModel): Int =
    model
      .pipe(in_appStates)
      .pipe(StateCasePipe.find_latest_Number)
