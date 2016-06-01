package controllers


import com.mongodb.util.JSON
import models.{Person, PersonDB, PersonFilter}
import play.api._
import play.api.mvc._
import views.html.person
import play.api.libs.json._

class Application extends Controller {
  private[controllers] val personDb: PersonDB = new PersonDB("localhost", 27017, "peopledb", "peoplecollection")

  def index = Action {
    Ok(views.html.index())
  }

  def person = Action { implicit request =>
    val name = request.getQueryString("name").toString
    personDb.startDb

    if (name != null) {
      val personList: List[Person] = List()
      val personFilter = new PersonFilter(name, "fName", "lName", "fullName")
      personFilter.filterPeople
      personDb.findPeople(personList, personFilter.getQuery)

       Ok("")
    }
    Ok(views.html.person())
  }

}
