import scala.annotation.tailrec
import scala.collection.immutable
import scala.io.StdIn.readLine

class Player(val name: String, var turn: Boolean, var winStatus: Boolean) {

  def declareMove(): List[Char] = {
    var pass = List('x','x')
    val towers = List('A','B','C')

    do {
      val move = readLine("Podaj ruch: ").toUpperCase()
      val moveList = move.toList.filter(_ != ' ')

      val f: (Char, Char) => List[Char] = (m, n) => {
        if (towers.contains(m) && towers.filterNot(_==m).contains(n)) m:: n :: Nil
        else 'x' :: 'x' :: Nil
      }

      moveList match {
        case m :: n :: Nil => pass = f(m, n)
        case _ => pass = 'x' :: 'x' :: Nil
      }
      if (pass == 0 :: 0 :: Nil) println("Podales nieprawidlowe wspolrzedne! Jeszcze raz! ")
    } while (pass == 'x' :: 'x' :: Nil);
    pass
  }
}