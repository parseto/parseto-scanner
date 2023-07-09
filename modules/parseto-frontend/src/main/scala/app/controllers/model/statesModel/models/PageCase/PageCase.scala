package parseto

val MobilePageCaseMap = Map(
  0 -> MobilePageCase.P0(),
  1 -> MobilePageCase.P01_all(),
  2 -> MobilePageCase.P02()
)

case class Move(prev: Int = 0, cur: Int = 0, next: Int = 0)

enum MobilePageCase:
  case P0(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 0, 1)
  ) extends MobilePageCase

  case P01_all(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 1, 0)
  ) extends MobilePageCase
  case P01_medi(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 1, 0)
  ) extends MobilePageCase

  case P02(
      name: String = "init",
      url: String = "Observer",
      actionButton: Move = Move(0, 2, 0)
  ) extends MobilePageCase
