object Day15:
  def soln1(lst: String): Int =
    lst.split(',').foldLeft(0)(_ + _.foldLeft(0)((l,r) => (l + r.toInt)*17 %256))

  def soln2(str: String): Int =
//    def calculateHash(s: String): Int = s.split("=")(0).foldLeft(0)((l, r) => (l + r.toInt)*17%265)

//    def hash(str: String): Int = str.foldLeft(0)((l, r) => (l + r.toInt) * 17 % 265)
//    def calculateHash(s: String): Int = hash(s.split("=")(0))
    def calculateHash(s: String): Int = soln1(s.split("=")(0))

    val map: Map[Int, List[Int]] = Map().withDefaultValue(List())

    str.split(',')
      .foldLeft(map){(m, s) =>
        if s.contains("=") then
          m + (calculateHash(s) -> (m(calculateHash(s)) :+ s.split("=")(1).toInt))
        else m(calculateHash(s.split("-")(0))) match
          case x :: xs => m + (calculateHash(s.split("-")(0)) -> xs)
          case Nil => m
      }.map((k, v) => v.reverse.foldLeft((1, 0))((l, r) => (l(0)+1, l(0)+r*l(0)))(1)).sum
