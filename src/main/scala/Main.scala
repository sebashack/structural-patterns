import logger._
import app.logger._
import app.logger.LoggerAdapter._

object Main extends App {
  val lg = new Logger

  println(lg.warning("Oh No!! Something's wrong"))

}
