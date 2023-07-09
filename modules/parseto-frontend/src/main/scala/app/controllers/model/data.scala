package parseto

case class BizSector(
    name: String,
    page: MobilePageCase = MobilePageCase.P01_all(),
    isClick: Boolean = false
)

object BizSectorInit:
  val value = List(
    BizSector("의료", MobilePageCase.P01_medi(), true),
    BizSector("법률"),
    BizSector("쇼핑몰"),
    BizSector("뉴스"),
    BizSector("숙박"),
    BizSector("공공기관"),
    BizSector("PC방"),
    BizSector("유통업"),
    BizSector("제조업"),
    BizSector("뷰티"),
    BizSector("당구장"),
    BizSector("스터디카페"),
    BizSector("요식업"),
    BizSector("1인기업")
  )

object BizSectorPipe:
  val css =
    Map(
      true -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 bg-blue-600 text-white",
      false -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 "
    )

  val cssFooter =
    Map(
      true -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-600 text-white rounded-b-[20px]",
      false -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-300 text-white rounded-b-[20px]"
    )

  def msg(data: List[BizSector], name: String) =
    BizSectorMsg.BizSectorUpdate(
      data.map(d =>
        d.name == name match
          case true => d.copy(isClick = !d.isClick)
          case _    => d.copy(isClick = false)
      )
    )
