package parseto

val MobilePageCaseMap = Map(
  0 -> MobilePageCase.P0(),
  1 -> MobilePageCase.P01_all(),
  2 -> MobilePageCase.P02_all()
)

case class Move(prev: Int = 0, cur: Int = 0, next: Int = 0)

enum MobilePageCase:
  case P0(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 0, 1),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase

  case P01_all(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 1, 1),
      pubs: List[PubCase] = List(new PubCase.ApiPub)
  ) extends MobilePageCase

  case P01x_matchSamples(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 1, 1),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase

  case P01xy(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(1, 1, 0),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase

  case P02_all(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 2, 0),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase

  case P021_all_dev(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 2, 0),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase

  case P021x_linkedPage(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 2, 0),
      pubs: List[PubCase] = List()
  ) extends MobilePageCase
