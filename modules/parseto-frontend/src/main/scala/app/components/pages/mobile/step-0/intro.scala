// package parseto
// import tyrian.*
// import cats.effect.IO
// import tyrian.Html.*
// import scala.util.chaining.*

// object IntroView:

//   def view(model: Model): Html[Msg] =
//     div(
//       `class` := Common.Css.layout
//     )(
//       MobileHeaderView.view,
//       MobileMainView.view(model.bizSector),
//       MobileFooterView.render(model)(
//         BizSectorPipe.cssFooter(
//           model.bizSector.map(d => d.isClick).contains(true)
//         )
//       )
//     )
