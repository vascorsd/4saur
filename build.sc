import $ivy.`com.lihaoyi::mill-contrib-bloop:0.4.1`

import mill._
import mill.scalalib._
import mill.scalalib.scalafmt.ScalafmtModule
import mill.contrib.Bloop

object app extends ScalaModule with ScalafmtModule {
  override
  def scalaVersion = "2.12.8"

  override
  def scalacOptions =
    Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-Ypartial-unification",
      "-Ypatmat-exhaust-depth", "off",
      "-Ywarn-unused:locals,imports"
    )

  override
  def scalacPluginIvyDeps =
    Agg(
      ivy"org.scalamacros:::paradise:2.1.1",
      ivy"org.typelevel::kind-projector:0.10.3",
      ivy"com.olegpy::better-monadic-for:0.3.0"
    )

  override 
  def ivyDeps = Agg(
    ivy"dev.zio::zio::1.0.0-RC9",
    ivy"dev.zio::zio-streams::1.0.0-RC9",
    ivy"com.softwaremill.tapir::tapir-core:0.8.9",
    ivy"com.softwaremill.tapir::tapir-json-circe:0.8.9",
    ivy"com.softwaremill.tapir::tapir-sttp-client:0.8.9",
    ivy"io.circe::circe-core:0.11.1",
    ivy"io.circe::circe-generic:0.11.1",
    ivy"io.circe::circe-parser:0.11.1",
    ivy"com.softwaremill.sttp::core:1.6.0",
  )
}

