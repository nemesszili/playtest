import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

class BrowserSpec extends PlaySpec with OneBrowserPerTest with GuiceOneServerPerSuite with HtmlUnitFactory {

  "Application" should {

    "work from within a browser" in {
      go to "http://localhost:" + port
      pageSource must include("Add Item")
    }
  }
}