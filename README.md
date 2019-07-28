# Playtest

## Learning project using the Play Framework with Slick

#### Steps to run

1. Open a console in the project's root
2. Run `sbt`
3. In the `sbt` console, run `update` - this should also resolve all dependencies
4. When done, run `h2-browser` - this should open the web interface for accessing H2 databases
5. Return to the `sbt` console and run the Play application with `run`
6. Navigate to `localhost:9000` and apply the SQL evolution script to re-create your table
7. Add a couple of items
8. Return to the H2 Browser and apply the following settings: 
    - From `Saved Settings` select `Generic H2 (Embedded)`
    - Set the `JDBC URL` to be `jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;`
    - Make sure both the `User Name` and `Password` fields are empty!
9. Connect and see if your changes have been applied to the table by executing a `SELECT`
10. Stop the application by pressing `Enter`

#### Sources

##### Theory
- [MVC](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
- [Inversion of Control](https://en.wikipedia.org/wiki/Inversion_of_control)
- [Dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection)

##### Execution
- [Lojinha - blog post](https://www.toptal.com/scala/scaling-play-to-thousands-of-concurrent-requests)
- [Lojinha - project](https://github.com/jcranky/lojinha)
- [Slick - simple](https://github.com/playframework/play-samples/tree/2.7.x/play-scala-slick-example)
- [Slick - module](https://github.com/playframework/play-samples/tree/2.7.x/play-scala-isolated-slick-example)
- [Databases in Play](https://www.playframework.com/documentation/2.7.x/ScalaDatabase)
- [H2 Database in Play](https://www.playframework.com/documentation/2.7.x/Developing-with-the-H2-Database)
- [Dependency Injection in Play](https://www.playframework.com/documentation/2.7.x/ScalaDependencyInjection)
- [Play application layout](https://www.playframework.com/documentation/2.7.x/Anatomy)

##### Testing
- [ScalaTestPlus](https://github.com/playframework/scalatestplus-play)
- [ScalaTestPlus examples](https://github.com/scalatest/scalatestplus-play-sample-app/tree/master/test)
- [Functional Testing](https://www.playframework.com/documentation/2.7.x/ScalaFunctionalTestingWithScalaTest)

##### Tweaking
- [Credentials for the in-memory DB through the H2 Browser](https://stackoverflow.com/questions/24655684/spring-boot-default-h2-jdbc-connection-and-h2-console/24727653#comment42814950_24727653) 
- [Conflicting dependencies](https://github.com/playframework/playframework/issues/7832#issuecomment-336014319)
- [To be checked later](https://www.playframework.com/documentation/2.7.x/ModuleDirectory)