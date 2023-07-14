// package parseto
// import tyrian.*
// import cats.effect.IO
// import tyrian.Html.*
// import scala.util.chaining.*

// object Parters_ALL_02:

//   def render(model: Model)(page: String): Html[Msg] =
//     page match
//       case "intro" =>
//         div(
//           `class` := Common.Css.layout
//         )(
//           MobileHeaderView.view,
//           MobileMainView.view(model.bizSector),
//           MobileFooterView.view(
//             BizSectorPipe.cssFooter(
//               model.bizSector.map(d => d.isClick).contains(true)
//             )
//           )
//         )

//       case "galuxy-note-10-display" =>
//         div(`class` := "galuxy-note-10")(
//           b("Camera"),
//           s(
//             Clock.view(model),
//             Noti.view(model)
//           ),
//           ActionButton.left(model),
//           ActionButton.right(model)
//         )

//       case "galuxy-note-10-intro" =>
//         div(`class` := "galuxy-note-10")(
//           b("Camera"),
//           s("10:24"),
//           iframe(
//             `class` := "mySmartphone content rounded-lg",
//             src := "https://wikipedia.org",
//             style := "width:100%;border:none;height:100%;border-radius:20px"
//           )(),
//           span()("Left action button"),
//           span()("Right action button")
//         )

//       case str: String =>
//         div(
//           `class` := Common.Css.layout
//         )(
//           MobileHeaderView.viewBack,
//           div(str)
//         )
