name := """study-titan-angularjs"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.thinkaurelius.titan" % "titan-core" % "1.0.0",
  "com.thinkaurelius.titan" % "titan-es" % "1.0.0",
  "com.thinkaurelius.titan" % "titan-cassandra" % "1.0.0"
)
