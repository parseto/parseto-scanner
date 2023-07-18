package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2
import parseto.ModelPipe.find_current_PageCase

object PageUpdate:
  def update(model: BlockModel): MobilePageMsg => (BlockModel, Cmd[IO, Msg]) =
    case MobilePageMsg.PreUpdate(page: MobilePageCase) =>
      page match
        case _ =>
          (
            model.copy(
              prodModel = model.prodModel.copy(
                appStates = model.prodModel.appStates ++ Seq(
                  StateCase(
                    number = ModelPipe.get_latest_number(model.prodModel) + 1,
                    mobilePageCase = page
                  )
                ),
                pointer = ModelPipe.get_latest_number(model.prodModel) + 1
              )
            ),
            Cmd.None
          )
    case MobilePageMsg.Next =>
      (
        model.copy(
        ),
        Cmd.Emit(
          MobilePageMsg.PreUpdate(
            model.prodModel.pipe(find_current_PageCase) match
              case page: MobilePageCase.P01_all =>
                model.prodModel.bizSector.filter(d => d.isClick)(0).page

              case page: MobilePageCase.P01x_matchSamples =>
                model.prodModel
                  .sampleSectorMap(
                    model.prodModel.bizSector.filter(d => d.isClick)(0).name
                  )
                  .filter(d => d.isClick)(0)
                  .page

              case page: MobilePageCase.P02_all =>
                model.prodModel.talkSector.filter(d => d.isClick)(0).page

              case page: MobilePageCase.P021_all_dev =>
                model.prodModel.profileSector.filter(d => d.isClick)(0).page

              case _ => model.prodModel.bizSector.filter(d => d.isClick)(0).page
          )
        )
      )
