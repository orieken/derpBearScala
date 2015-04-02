name := "Derp Bear Scala"

version := "0.1.0"

scalaVersion := "2.11.6"

organization := "com.derpbear"

resolvers += "justwrote" at "http://repo.justwrote.it/releases/"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
libraryDependencies += "org.scalaj" %% "scalaj-http" % "1.1.4"
libraryDependencies += "net.liftweb" %% "lift-json" % "2.6+"
libraryDependencies += "it.justwrote" %% "scala-faker" % "0.3"