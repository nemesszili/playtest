package models.slick

import javax.inject.{Inject, Singleton}
import models.{Item, ItemDAO}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class SlickItemDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends ItemDAO with HasDatabaseConfigProvider[JdbcProfile] {
  // This import is important as it brings the Slick DSL into scope, which lets you define the table and other queries.
  import profile.api._

  /**
    * Here we define the table. It will have the name of items
    */
  private class ItemTable(tag: Tag) extends Table[Item](tag, "items") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def name = column[String]("name")

    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Item object.
      *
      * In this case, we are simply passing the id, name and page parameters to the Item case classes
      * apply and unapply methods.
      */
    def * = (id, name) <> ((Item.apply _).tupled, Item.unapply)
  }

  private val items = TableQuery[ItemTable]

  override def all: Future[Seq[Item]] = db.run {
    items.result
  }

  override def create(name: String): Future[Item] = db.run {
    // We create a projection of just the name column, since we're not inserting a value for the id column
    (items.map(p => p.name)
      // Now define it to return the id, because we want to know what id was generated for the person
      returning items.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
      into ((data, id) => Item(id, data))
      // And finally, insert the person into the database
      ) += name
  }
}
