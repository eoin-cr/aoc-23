import scala.annotation.tailrec

object Day2:
  def getGameId(s: String): Int =
    s.split(" ")(1).replace(":", "").toInt


//  private def validGame(s: String, max: Map[String, Int]): Boolean =
//    @tailrec
//    def validGameHelper(st: List[String], acc: Map[String, Int] = Map()): Map[String, Int] =
//      st match
//        case x :: xs => validGameHelper(xs, acc + ((x.split(" ")(1), acc.getOrElse(x.split(" ")(1), 0)+x.split(" ")(0).toInt)))
//        case Nil => acc
//
////    def isValid(bounds: Map[String, Int], curr: Map[String, Int]) =
////      curr.forall((s, i) => bounds.getOrElse(s, -1) >= i)
//
//    val games = s.split(":")(1).replace(", ", ",").replace("; ", ";").split(";").map(_.trim)
////    games.forall(x => validGameHelper(x.split(",").toList).forall((k, i) => max.getOrElse(k, -1) >= i))
//    games
//      .forall(x => x.split(",").toList
//        .foldLeft(Map())((m, str) => m + (str.split(" ")(1), m.getOrElse(str.split(" ")(1), 0)+str.split(" ")(0).toInt))
//        .forall((k, i) => max.getOrElse(k, -1) >= i))
//
//
//  def soln1(lst: List[String]): Int =
//    val maxCubes = Map(("red", 12), ("green", 13), ("blue", 14))
//    lst.filter(validGame(_, maxCubes)).foldLeft(0)(_ + getGameId(_))

  private def validGame2(s: String, max: Map[String, Int]): Int =
    @tailrec
    def getMaxValues(st: List[String], acc: Map[String, Int] = Map()): Map[String, Int] =
      st match
        case x :: xs =>
          val maxOcc = acc.getOrElse(x.split(" ")(1), 0)
          getMaxValues(xs, acc + ((x.split(" ")(1), maxOcc max x.split(" ")(0).toInt)))
        case Nil => acc

    val games = s.split(":")(1).replace(", ", ",").replace("; ", ",").trim
//    games.forall(x => getMaxValues(x.split(",").toList).forall((k, i) => max.getOrElse(k, -1) >= i))
//    games.map(x => getMaxValues(x.split(",").toList)).values.reduce(_ * _)
    getMaxValues(games.split(",").toList).values.product

  def soln2(lst: List[String]): Int =
    val maxCubes = Map(("red", 12), ("green", 13), ("blue", 14))
    lst.map(validGame2(_, maxCubes)).sum
