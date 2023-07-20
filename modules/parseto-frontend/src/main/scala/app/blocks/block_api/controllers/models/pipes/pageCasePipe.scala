package parseto
import scala.util.chaining.*
import cats.instances.seq

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
