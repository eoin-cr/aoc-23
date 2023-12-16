//object Day1v2:
//  def soln(INPUT: List[String]): Int =
//    INPUT.map(l => {
//      def num(s: String): Option[Int] =
//        val nums = List(
//          ("1", "one"),
//          ("2", "two"),
//          ("3", "three"),
//          ("4", "four"),
//          ("5", "five"),
//          ("6", "six"),
//          ("7", "seven"),
//          ("8", "eight"),
//          ("9", "nine")
//        )
//        nums
//          .zipWithIndex
//          .filter(tpl => s.startsWith(tpl._1)).map(_._2 + 1).headOption
//
//      val n1 = (0 until l.length).view.map(n => num(l.slice(n,l.length))).find(_.isDefined).get.get
//      val n2: Int = (0 until l.length).reverse.view.map(n => num(l.slice(n, l.length))).find(_.isDefined).get.get
//      (n1 * 10) + n2
//    }).sum