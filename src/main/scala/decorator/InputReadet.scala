package input.reader

import java.io.BufferedReader
import collection.JavaConverters._


trait InputReader {
  def readLines(): Stream[String]
}

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
  def readLines(): Stream[String] =
    reader.lines().iterator.asScala.toStream
}
