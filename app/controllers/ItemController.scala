package controllers

import javax.inject._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ItemController @Inject()(itemDAO: ItemDAO,
                               cc: MessagesControllerComponents
                              )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val itemForm: Form[CreateItemForm] = Form {
    mapping(
      "name" -> nonEmptyText
    )(CreateItemForm.apply)(CreateItemForm.unapply)
  }

  def index = Action { implicit request =>
    Ok(views.html.index(itemForm))
  }

  def addItem = Action.async { implicit request =>
    itemForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok(views.html.index(errorForm)))
      },
      // There were no errors in the from, so create the item.
      item => {
        itemDAO.create(item.name).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.ItemController.index).flashing("success" -> "item.created")
        }
      }
    )
  }

  def getItems = Action.async { implicit request =>
    itemDAO.all.map { item =>
      Ok(Json.toJson(item))
    }
  }
}

case class CreateItemForm(name: String)