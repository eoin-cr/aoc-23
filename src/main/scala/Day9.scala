object Day9:
  def calculateNext(st: List[Int]): Int =
    def helper(st:List[Int]): Int =
      val diff = st.sliding(2).map(x => x.head-x(1)).toList
      diff match
        case _ if diff.forall(_ == 0) => st.head + 0
        case _ => st.head + helper(diff)

    // do our calculation reversed to avoid a bunch of .last calls
    helper(st.reverse)

  def soln1(lst: List[String]): Int =
//    lst.foldLeft(0)((l, r) => l + calculateNext(r.split(" ").toList.map(_.toInt)))
    lst.map(x => calculateNext(x.split(" ").toList.map(_.toInt))).sum
