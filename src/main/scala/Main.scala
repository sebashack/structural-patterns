import java.io.BufferedReader
import java.io.BufferedInputStream
import java.io.InputStreamReader
import logger._
import app.logger._
import app.logger.LoggerAdapter._
import reader.decorator._
import input.reader._
import password.converter._
import hasher._

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

  val p1 = new SimplePasswordConverter with Sha256Hasher
  val p2 = new SaltedPasswordConverter("sdf<3<4&%") with Sha1Hasher
}
