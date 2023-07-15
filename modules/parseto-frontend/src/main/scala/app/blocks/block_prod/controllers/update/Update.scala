// package parseto
// import tyrian.*
// import cats.effect.IO

// object Update:
//   def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
//     // msg => update
//     case pageMsg: MobilePageMsg => PageUpdate.update(model)(pageMsg)

//     case bizSectorMsg: BizSectorMsg =>
//       BizSectorUpdate.update(model)(bizSectorMsg)

//     case stepMsg: StepMsg =>
//       StepUpdate.update(model)(stepMsg)

//     case tickMsg: RealTimeMsg =>
//       RealTimeUpdate.update(model)(tickMsg)
