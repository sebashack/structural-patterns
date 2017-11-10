import java.io.BufferedReader
import java.io.BufferedInputStream
import java.io.InputStreamReader
import logger._
import app.logger._
import app.logger.LoggerAdapter._
import reader.decorator._
import input.reader._

object Main extends App {
  val lg = new Logger

  println(lg.warning("Oh No!! Something's wrong"))

  val stream = new BufferedReader((new InputStreamReader(
    new BufferedInputStream(
      this.getClass.getResourceAsStream("/home/sebashack/scalaTest/structual/data.txt"))
  )))

  val reader = new AdvancedInputReader(stream)
      with CapitalizedInputReader
      with Base64EncoderInputReader
}
