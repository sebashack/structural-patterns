package reader.decorator

import input.reader._
import java.nio.charset._
import java.util.Base64


abstract class InputReaderDecorator(inputReader: InputReader)
    extends InputReader {
  def readLines(): Stream[String] =
    inputReader.readLines()
}

class CapitalizedInputReader(inputReader: InputReader)
    extends InputReaderDecorator(inputReader) {
  override def readLines(): Stream[String] =
    super.readLines().map(_.toUpperCase)
}

class Base64EncoderInputReader(inputReader: InputReader)
    extends InputReaderDecorator(inputReader) {
  override def readLines(): Stream[String] =
    super.readLines().map ((line) => {
      Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8")))
    })
}
