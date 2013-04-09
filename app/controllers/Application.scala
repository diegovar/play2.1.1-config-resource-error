package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {
  
  private def JsonResult(status: Int, body: String) = Status(status)(body).withHeaders(CONTENT_TYPE -> "application/json")
  
  def index = Action {
    JsonResult(200, Json.toJson(Map(
		"config.resource system property" -> System.getProperty("config.resource").toString,
		"conf file origin" -> play.api.Play.current.configuration.underlying.origin.toString,
		"test.number" -> play.api.Play.current.configuration.getInt("test.number").toString
	)).toString)
  }
  
}