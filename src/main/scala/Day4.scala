object Day4:
  def soln1(lst: List[String]): Int =
    def numWinning(s: String): Int =
      val splitNums = s.strip().split("\\|")
      splitNums(1).split(" ").foldLeft(0)((l, r) => l + (if ((splitNums(0).split(" ") contains r) && r.strip() != "") 1 else 0))

    lst.foldLeft(0)((total, str) => total + scala.math.pow(2, numWinning(str.split(":")(1))-1).toInt)