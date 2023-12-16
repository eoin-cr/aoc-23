import scala.annotation.tailrec

object Day15:
  def soln1(lst: String): Int =
    lst.split(',').foldLeft(0)(_ + _.foldLeft(0)((l,r) => (l + r.toInt)*17 %256))

  def soln2(str: String): Int =
    def calculateHash(s: String): Int = soln1(s.split("=")(0))
    @tailrec
    def replaceInList(s: String, newVal: Int, lst: List[(String, Int)], acc: List[(String, Int)]=List()): List[(String, Int)] =
      lst match
        case x :: xs if x(0) == s => acc.reverse ::: ((s, newVal) :: xs)
        case x :: xs => replaceInList(s, newVal, xs, x :: acc)
        case Nil if acc == Nil => List((s, newVal))
        case Nil => ((s, newVal) :: acc).reverse

    @tailrec
    def removeFromList(s: String, lst: List[(String, Int)], acc: List[(String, Int)]=List()): List[(String, Int)] =
      lst match
        case x :: xs if x(0) == s => acc.reverse ::: xs
        case x :: xs => removeFromList(s, xs, x :: acc)
        case Nil => acc.reverse

    val map: Map[Int, List[(String, Int)]] = Map().withDefaultValue(List())

    str.split(',')
      .foldLeft(map){(m, s) =>
        if s.contains("=") then
          val label = s.split("=")(0)
          val lens = s.split("=")(1).toInt
          m + (calculateHash(label) -> replaceInList(label, lens, m(calculateHash(label))))
        else
          val label = s.split("-")(0)
          val labelHash = calculateHash(label)
          m + (labelHash -> removeFromList(label, m(labelHash)))
      }.map((k, v) => v.foldLeft((1, 0))((l, r) => (l(0) + 1, l(1) + (k + 1) * r(1) * l(0)))(1)).sum