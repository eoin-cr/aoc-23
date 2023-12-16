import scala.annotation.tailrec

//object Day3:
//  private def isSpecial(s: Char): Boolean = !s.isLetterOrDigit && s != '.'
//  private def isSpecial(lst: List[Char]): Boolean = lst match
//    case x :: xs => isSpecial(x)
//    case Nil => false
//  private def isSpecial(first: List[Char], second: List[Char], third: List[Char]): Boolean =
//    isSpecial(first) || isSpecial(second) || isSpecial(third)
//  private def tailOrNil[A](st: List[A]): List[A] = st match
//    case x :: xs => xs
//    case Nil => Nil
//
//  @tailrec
//  private def sumPartsInLine(top: List[Char], middle: List[Char], bottom: List[Char],
//                             prevNum: Int=0, prevSpecial: Boolean=false, acc: Int = 0): Int =
//    middle match
//      case x :: xs if x.isDigit => sumPartsInLine(tailOrNil(top), xs, tailOrNil(bottom),
//        prevNum * 10 + x.asDigit, isSpecial(top, middle, bottom) || prevSpecial, acc)
//      case x :: xs if prevSpecial || isSpecial(top, middle, bottom) =>
//        sumPartsInLine(tailOrNil(top), xs, tailOrNil(bottom), 0, isSpecial(top, middle, bottom), prevNum + acc)
//      case x :: xs => sumPartsInLine(tailOrNil(top), xs, tailOrNil(bottom), 0, false, acc)
//      case Nil if prevSpecial => prevNum + acc
//      case Nil => acc
//
//  def soln1(lst: List[String]): Int =
//    ("" :: (lst :+ "")).sliding(3).foldLeft(0)((l, tpl) => l + sumPartsInLine(tpl.head.toList, tpl(1).toList, tpl(2).toList))
//
//  private def emptyLine(top: Char, mid: Char, bot: Char): Boolean =
//  //    !(top.isDigit || top == '*')
//    (top, mid, bot).forall(x => !(x.isDigit || x == '*'))
//
//  private def tailOrSpace[A](lst: List[A]): List[A] = lst match
//    case x :: xs => xs
//    case Nil => ' '
//
//  @tailrec
//  private def sumGearRatioInLine(top: List[Char], middle: List[Char], bottom: List[Char],
//                                 prevTop: Int = 0, prevMid: Int = 0, prevBot: Int = 0,
//                                 prevGear: Boolean = false, prevProd: Int = 1, acc: Int = 0): Int =
//    middle match
//      case x :: xs if emptyLine(top, middle, bottom) =>
//        sumGearRatioInLine(tailOrSpace(top), xs, tailOrSpace(bottom),
//          acc=if prevProd > 1 then acc+prevProd else acc)
//      case x :: xs if middle == '*' => sumGearRatioInLine(tailOrSpace(top), xs, tailOrSpace(bottom),
//          )
//
//
//  def soln2(lst: List[String]): Int =
////    ("" :: (lst :+ "")).sliding(3).foldLeft(0)((l, tpl) => l + sumPartsInLine(tpl.head.toList, tpl(1).toList, tpl(2).toList))
