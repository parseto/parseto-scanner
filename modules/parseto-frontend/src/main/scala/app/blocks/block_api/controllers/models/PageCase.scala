package parseto

enum PageCase:
  case DashBoard(
      name: String = "Dashboard",
      url: String = "dashboard",
      pubs: List[PubCase] = List(
        new PubCase.TxPub
      )
  ) extends PageCase
