import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "LALA"
    val appVersion      = "1.0"
	val scalaVersion = "2.9.2"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )
	
	def configOnLoad(s: State) = {
    if(System.getProperty("config.resource") == null)
      System.setProperty("config.resource", "local.conf")
    println("config.resource =" + System.getProperty("config.resource"))
    s
  }

    val main = play.Project(appName, appVersion, appDependencies).settings(
      onLoad in Global ~= (configOnLoad _ compose _)
    )

}
