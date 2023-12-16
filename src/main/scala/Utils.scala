//import scala.io.BufferedSource
import scala.io.Source

object Utils:
  def readFileAsList(name: String): List[String] =
    val bufferedSource = Source.fromFile(name)
    val lines = bufferedSource.getLines().toList
    bufferedSource.close
    lines

  def readFileFirstLineAsString(name: String): String =
    val bufferedSource = Source.fromFile(name)
    val str = bufferedSource.getLines().toList.head
    bufferedSource.close
    str
