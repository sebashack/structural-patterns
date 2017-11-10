package reader.decorator

import input.reader._
import java.nio.charset._
import java.util.Base64


trait CapitalizedInputReader extends InputReader {
  abstract override def readLines(): Stream[String] =
    super.readLines().map(_.toUpperCase)
}

trait Base64EncoderInputReader extends InputReader {
  abstract override def readLines(): Stream[String] =
    super.readLines().map ((line) => {
      Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8")))
    })
}
