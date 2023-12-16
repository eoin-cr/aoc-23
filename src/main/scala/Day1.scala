import scala.annotation.tailrec

class Day1():
//  def getLast()
  def wordToInt(s: String): Option[Int] =
    @tailrec
    def findMatch(s: String, numRep: List[String], nums: List[Int]): Option[Int] = numRep match
      case x :: xs if s.startsWith(x) => Some(nums.head)
      case x :: xs => findMatch(s, xs, nums.tail)
      case _ => None

    if s(0).isDigit then s(0).toString.toIntOption
    else findMatch(s, List("one", "two", "three", "four", "five", "six", "seven", "eight", "nine"),
      List(1,2,3,4,5,6,7,8,9))

  def convertToInts(s: String): List[Int] =
    @tailrec
    def go(s: String, acc: List[Option[Int]] = Nil): List[Option[Int]] = s match
      case _ if s.length > 1 => go(s.substring(1), wordToInt(s) :: acc)
      case _ => wordToInt(s) :: acc

    go(s).flatten

  def combineFirstAndLastNumber(lst: List[Int]): Int =
    lst match
      case x :: Nil => s"$x$x".toInt
      case x :: xs => s"${xs.reduce((x, y) => y)}$x".toInt
      case Nil => 0

  def soln1(lst: List[String]): Int =
    lst.foldLeft(0)((x, y) => x + combineFirstAndLastNumber(convertToInts(y)))
