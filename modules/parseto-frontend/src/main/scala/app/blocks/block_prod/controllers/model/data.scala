package parseto

case class BizSector(
    name: String,
    page: MobilePageCase = MobilePageCase.P01x_matchSamples(),
    isClick: Boolean = false
)

object BizSectorInit:
  val value = List(
    BizSector("의료", MobilePageCase.P01x_matchSamples(), true),
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

  def msg(name: String) =
    BizSectorMsg.BizSectorUpdate(
      name
    )

case class TalkSector(
    name: String,
    page: MobilePageCase = MobilePageCase.P02_all(),
    // url: String = "",
    isClick: Boolean = false
)

object TalkSectorInit:
  val value = List(
    TalkSector("개발1:1", MobilePageCase.P021_all_dev(), true),
    TalkSector("디자인")
  )

object TalkSectorPipe:
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

  def msg(name: String) =
    TalkSectorMsg.TalkSectorUpdate(
      name
    )

case class ProfileSector(
    name: String,
    page: MobilePageCase = MobilePageCase.P021x_linkedPage(),
    isClick: Boolean = false,
    url: String = "https://open.kakao.com/o/sCJSFJvf"
)

object ProfileSectorInit:
  val value = List(
    ProfileSector("파스투소프트", MobilePageCase.P021x_linkedPage(), true),
    ProfileSector("파스투디자인")
  )

object ProfileSectorPipe:
  val css =
    Map(
      true -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 bg-blue-600 text-white",
      false -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 "
    )

  val img = ""

  val cssFooter =
    Map(
      true -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-600 text-white rounded-b-[20px]",
      false -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-300 text-white rounded-b-[20px]"
    )

  def msg(name: String) =
    ProfileSectorMsg.ProfileSectorUpdate(
      name
    )

case class SampleSector(
    name: String,
    page: MobilePageCase = MobilePageCase.P021x_linkedPage(),
    isClick: Boolean = false,
    url: String = ""
)

object SampleInit:
  val value = Map(
    "의료" -> List(
      SampleSector("굿닥", MobilePageCase.P021x_linkedPage(), true),
      SampleSector("닥터나우")
    ),
    "랜덤" -> List(
      SampleSector("한국", MobilePageCase.P021x_linkedPage(), true),
      SampleSector("중국")
    )
  )

object SampleSectorPipe:
  val css =
    Map(
      true -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 bg-blue-600 text-white",
      false -> "h-16 border border-gray-300 rounded-lg hover:font-bold hover:border-blue-300 "
    )

  val img = ""

  val cssFooter =
    Map(
      true -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-600 text-white rounded-b-[20px]",
      false -> "left-0 w-full flex py-4 justify-center font-medium bg-blue-300 text-white rounded-b-[20px]"
    )

  def msg(name: String) =
    SampleSectorMsg.SampleSectorUpdate(
      name
    )
