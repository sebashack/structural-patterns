package data.reader

import java.util.Base64
import org.json4s._
import org.json4s.jackson._


trait DataDownloader {
  def download(url: String): Array[Byte] = {
    println("Downloading from: {}", url)
    Thread.sleep(5000)

    val data =
      "ew0KICAgICJuYW1lIjogIkl2YW4iLA0KICAgICJhZ2UiOiAyNg0KfQ=="

    data.getBytes
  }
}

trait DataDecoder {
  def decode(data: Array[Byte]): String =
    new String(Base64.getDecoder.decode(data), "UTF-8")
}

trait DataDeserializer {
  implicit val formats = DefaultFormats

  def parse[T](data: String)(implicit m: Manifest[T]): T =
    JsonMethods.parse(StringInput(data)).extract[T]
}


case class Person(name: String, age: Int)


class DataReader extends DataDownloader
    with DataDecoder with DataDeserializer {
  def readPerson(url: String): Person = {
    val data = download(url)
    val json = decode(data)

    parse[Person](json)
  }

}
