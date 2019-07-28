package models

import play.api.libs.json.Json

import scala.concurrent.Future

trait ItemDAO {
  def all: Future[Seq[Item]]
  def create(name: String): Future[Item]
}

/**
  * Implementation independent aggregate root.
  */
case class Item(id: Long, name: String)

object Item {
  implicit val itemFormat = Json.format[Item]
}
