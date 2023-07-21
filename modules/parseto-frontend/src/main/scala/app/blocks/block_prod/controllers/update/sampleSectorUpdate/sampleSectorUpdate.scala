package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.parseto.common.function.logs.log2

object SampleSectorUpdate:
  def update(
      model: BlockModel
  ): SampleSectorMsg => (BlockModel, Cmd[IO, Msg]) =
    case SampleSectorMsg.SampleSectorUpdate(name) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(sampleSectorMap =
            model.prodModel.sampleSectorMap +
              (model.prodModel.bizSector.filter(d => d.isClick)(0).name ->
                model.prodModel
                  .sampleSectorMap(
                    model.prodModel.bizSector.filter(d => d.isClick)(0).name
                  )
                  .map(d =>
                    d.name == name match
                      case true => d.copy(isClick = !d.isClick)
                      case _    => d.copy(isClick = false)
                  ))
          )
        ),
        Cmd.None
      )
    case SampleSectorMsg.SampleSectorReplace(sampleMap) =>
      (
        model.copy(
          prodModel = model.prodModel.copy(sampleSectorMap = sampleMap)
        ),
        Cmd.None
      )
