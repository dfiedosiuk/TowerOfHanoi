import scala.annotation.tailrec
import scala.collection.immutable
import scala.io.StdIn.readLine

class Player {

  def declareMove(): List[Int] = {
    var pass = List(0,0)
    val towers = List('A', 'B', 'C')
    val values = List(0, 1, 2)

    do {
      val move = readLine("Enter move: ").toUpperCase()
      val moveList = move.toList.filter(_ != ' ')
      val f: (Char, Char) => List[Int] = (m, n) => {
        if (towers.contains(m) && towers.filterNot(_ == m).contains(n)) values(towers.indexOf(m)) :: values(towers.indexOf(n)) :: Nil
        else 0 :: 0 :: Nil
      }
      moveList match {
        case m :: n :: Nil => pass = f(m, n)
        case _ => pass = 0 :: 0 :: Nil
      }
      if (pass == 0 :: 0:: Nil) println("Wrong move! Try again. ")
    } while (pass == 0 :: 0 :: Nil);
    pass
  }
}