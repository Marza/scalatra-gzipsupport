organization := "se.marza"

name := "scalatra-gzipsupport"

version := "0.1"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.1.1",
  "javax" % "javaee-api" % "6.0" % "provided"
)

publishTo := Some(Resolver.file("file",  new File( "../repository/releases" )) )
