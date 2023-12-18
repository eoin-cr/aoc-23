object Day9:
  def calculateNew(st: List[Int], f: List[Int] => Int, g: (Int, BigInt) => BigInt): BigInt =
    val diff = st.sliding(2).map(x => f(x)).toList
    diff match
      case _ if diff.forall(_ == 0) => st.head
      case _ => g(st.head, calculateNew(diff, f, g))

  def soln1(lst: List[String]): BigInt =
    lst.foldLeft(0: BigInt)((l, r) => l + calculateNew(r.split(" ").toList.map(_.toInt).reverse, x => x.head-x(1), _ + _))

  def soln2(lst: List[String]): BigInt =
    lst.foldLeft(0: BigInt)((l, r) => l + calculateNew(r.split(" ").toList.map(_.toInt), x => x(1) - x.head, _ - _))
