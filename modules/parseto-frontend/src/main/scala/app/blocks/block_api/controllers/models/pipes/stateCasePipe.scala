package parseto
import scala.scalajs.js
import scala.util.chaining.*

// TODO:: go, pipe 함수로 redesign!
object ApiModelStateCasePipe:
  def in_pageCase(state: ApiModelStateCase) = state.apiModelPageCase

  def in_number(state: ApiModelStateCase) = state.number

  def find_State(find: Int)(
      states: List[ApiModelStateCase]
  ): ApiModelStateCase =
    // find 가 0이면 가장 최신 옵져버로 검색할수 있게 해준다
    val _find = find match
      case 0 => states.length
      case _ => find
    states.filter(state => state.number == _find)(0)

  def find_Number(find: Int = 0)(states: List[ApiModelStateCase]) =
    states
      .pipe(find_State(find))
      .pipe(in_number)

  def find_latest_Number(states: List[ApiModelStateCase]) =
    states
      .pipe(find_State(0))
      .pipe(in_number)

  def find_PageCase(find: Int = 0)(states: List[ApiModelStateCase]) =
    states
      .pipe(find_State(find))
      .pipe(in_pageCase)

  def update_PubData(pub: PubCase, find: Int)(state: ApiModelStateCase) =
    state.number == find match
      case true =>
        state.copy(apiModelPageCase =
          ApiPageCasePipe.update_PageCase_PubCases(state.apiModelPageCase, pub)
        )
      case _ => state
