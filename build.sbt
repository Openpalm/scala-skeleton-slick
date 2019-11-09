name := "myApp"
version := "1.0"
scalaVersion := "2.12.10"


libraryDependencies ++= Seq(
		"com.typesafe.slick" %% "slick" % "3.3.1",
		"org.slf4j" % "slf4j-nop" % "1.7.26",
		"com.typesafe.slick" %% "slick-hikaricp" % "3.3.1",
		"com.lihaoyi" % "ammonite" % "1.8.1" % "test" cross CrossVersion.full,
		"org.scalatest" %% "scalatest" % "3.0.5" % Test
		)

sourceGenerators in Test += Def.task {
	val file = (sourceManaged in Test).value / "amm.scala"
		IO.write(file, """object amm extends App { ammonite.Main.main(args) }""")
		Seq(file)
}.taskValue

trapExit := false
