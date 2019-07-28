import org.scalatest._
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends PlaySpec with GuiceOneAppPerTest with OptionValues {

  "Application" should {

    "send 404 on a bad request" in {
      status(route(app, FakeRequest(GET, "/kecske")).get) mustEqual NOT_FOUND
    }

    "render the index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustEqual OK
      contentType(home).value mustBe "text/html"
      contentAsString(home) must include("Add Item")
    }
  }
}