ThisBuild / organization := "org.inverseplayers"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / scalaVersion := V.Scala
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"

val V = new {
  val tyrian = "0.6.2"
  val tyrian_new = "0.7.1"
  val Scala = "3.2.2"
  val Scala_new = "3.3.0"
  val circe = "0.15.0-M1"
}

val Dependencies = new {
  lazy val devscanFrontend = Seq(
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "tyrian-io" % V.tyrian,
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.0",
      "io.circe" %%% "circe-core" % V.circe,
      "io.circe" %%% "circe-generic" % V.circe,
      "io.circe" %%% "circe-parser" % V.circe
    )
  )
  lazy val scannerFrontend = Seq(
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "tyrian-io" % V.tyrian_new,
      "io.circe" %%% "circe-core" % V.circe,
      "io.circe" %%% "circe-generic" % V.circe,
      "io.circe" %%% "circe-parser" % V.circe
    )
  )
  lazy val parsetoCommon = Seq(
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % V.circe,
      "io.circe" %%% "circe-generic" % V.circe,
      "io.circe" %%% "circe-parser" % V.circe,
      "io.indigoengine" %%% "tyrian-io" % V.tyrian
    )
  )
}

lazy val root = (project in file("."))
  .aggregate(
    devscanFrontend,
    parsetoCommon,
    parsetoFrontEnd,
    scannerFrontend
  )

lazy val devscanFrontend = (project in file("modules/devscan-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.devscanFrontend)
  .settings(
    name := "devscan-frontend",
    scalaVersion := s"${V.Scala}",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
  .dependsOn(parsetoCommon)

lazy val parsetoFrontEnd = (project in file("modules/parseto-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.devscanFrontend)
  .settings(
    name := "parseto-frontend",
    scalaVersion := s"${V.Scala}",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
  .dependsOn(parsetoCommon)

lazy val parsetoCommon = (project in file("modules/parseto-common"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.parsetoCommon)
  .settings(
    name := "parseto-common",
    scalaVersion := s"${V.Scala}",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scannerFrontend = (project in file("modules/scanner-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.scannerFrontend)
  .settings(
    name := "scanner-frontend",
    scalaVersion := s"${V.Scala_new}",
    version := "0.0.1",
    organization := "parseto",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
