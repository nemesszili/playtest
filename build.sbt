name := "playtest"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.13.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

// https://github.com/playframework/playframework/issues/7832#issuecomment-336014319
// https://github.com/playframework/playframework/blob/2.7.x/project/Dependencies.scala
val akkaVersion = "2.5.23"
dependencyOverrides ++= Seq(
  "com.typesafe" %% "ssl-config-core" % "0.3.8",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.google.guava" % "guava" % "27.1-jre",
  "org.slf4j" % "slf4j-api" % "1.7.26"
)

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-slick" % "4.0.2",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.2",
  "com.h2database" % "h2" % "1.4.199",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % "test",
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)