package parseto
import scala.util.chaining.*
import cats.instances.seq

case class PageResponseViewCase(
    var txs: List[Transaction] = List(Transaction())
)

object ApiPageCasePipe:
  def in_Name(pageCase: ApiModelPageCase) =
    pageCase match
      case page: ApiModelPageCase.DashBoard => page.name

  def in_url(pageCase: ApiModelPageCase) =
    pageCase match

      case page: ApiModelPageCase.DashBoard => page.url

  def in_PubCases(pageCase: ApiModelPageCase) =
    pageCase match
      case page: ApiModelPageCase.DashBoard => page.pubs

  def update_PageCase_PubCases(pageCase: ApiModelPageCase, pub: PubCase) =
    // case pageCase: PageCase.Blocks =>
    //   pageCase.copy(pubs = in_PubCases(pageCase) ++ List(pub))
    pageCase match
      case page: ApiModelPageCase.DashBoard =>
        page.copy(pubs = in_PubCases(pageCase) ++ List(pub))

  def pipe_PageResponseViewCase(
      pageCase: ApiModelPageCase
  ): PageResponseViewCase =
    var res = new PageResponseViewCase()
    pageCase
      .pipe(in_PubCases)
      .map(pub =>
        pub match
          case pub: PubCase.TxPub =>
            res.txs = pub.pub_m2
      )
    res
