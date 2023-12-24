object Day24:
  val MAX_X = 400000000000000L
  val MAX_Y = 400000000000000L
  val MIN_X = 200000000000000L
  val MIN_Y = 200000000000000L
//  val MAX_X = 27
//  val MAX_Y = 27
//  val MIN_X = 7
//  val MIN_Y = 7

  private def inputStringToList(s: String) =
    s.split(" @ ").flatMap(_.split(", ").map(_.toFloat))

  def calculateCrossing(a: Array[Float], b: Array[Float]): (Float, Float) =
    val x1 = a(0)
    val x2 = b(0)
    val y1 = a(1)
    val y2 = b(1)
    val ux1 = a(3)
    val ux2 = b(3)
    val uy1 = a(4)
    val uy2 = b(4)

    val m1 = uy1/ux1
    val m2 = uy2/ux2
    val b1 = y1 - m1*x1
    val b2 = y2 - m2*x2

    if m1 == m2 then (0, 0)
    else
      val x = (b2-b1)/(m1-m2)
      val y = m1 * x + b1

      if ((ux2 >= 0 && x >= x2) || (ux2 < 0 && x < x2)) && ((ux1 >=0 && x >= x1) || (ux1 < 0 && x < x1)) then (x,y) else (0,0)

  private def isValid(cross: (Float, Float)): Int =
    if cross(0) < MAX_X && cross(0) > MIN_X && cross(1) < MAX_Y && cross(1) > MIN_Y then 1 else 0

  def soln1(st: List[String]): Int =
    st.foldLeft(0)((acc1, x) => acc1 + st.foldLeft(0)((acc2, y) => acc2 + isValid(calculateCrossing(inputStringToList(x), inputStringToList(y))))) / 2