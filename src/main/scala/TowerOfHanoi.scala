import scala.collection.mutable
import scala.io.StdIn.{readChar, readLine}

class TowerOfHanoi(var isGameFinished: Boolean) {

  val towers: Array[mutable.Stack[Int]] = {
    var n = 0
    var ringsAmount = 0

    def myReadChar(prompt: String): Char = {
      print(prompt)
      java.lang.System.out.flush()
      readChar()
    }

    do {
      ringsAmount = myReadChar("Set height of Hanoi Tower (from 3 to 8):  ").toInt
      ringsAmount -=48
      if (!(3 to 8 contains (ringsAmount))) println("Wrong input! Try again. ")
    } while (!(3 to 8 contains (ringsAmount)))
    Array(mutable.Stack[Int]() pushAll (ringsAmount to 1 by -1), mutable.Stack[Int](), mutable.Stack[Int]())
  }

  def printTowers(towers: Array[mutable.Stack[Int]]): Unit = {
    val towersName = List("A ", "B ", "C ")
    for (n <- 0 to 2) println(towersName(n) + towers(n).reverse)
  }

  def makeMove(towers: Array[mutable.Stack[Int]], p: Player): Array[mutable.Stack[Int]] = {
    printTowers(towers)
    val actualMove = p.declareMove()
    val f: (Int, Int) => Array[mutable.Stack[Int]] = (giver, receiver) => {
      if ((towers(giver).nonEmpty && towers(receiver).isEmpty) || (towers(giver).nonEmpty && towers(receiver).top > towers(giver).top)) {
        towers(receiver).push(towers(giver).pop)
        towers
      }
      else {
        println("Not possible move! Try again. ")
        makeMove(towers, p)
      }
    }
    actualMove match {
      case m :: n :: Nil => f(m, n)
    }
  }

  val isFinished: (Array[mutable.Stack[Int]]) => Boolean = towers => {
    if (towers(0).isEmpty && towers(1).isEmpty) {
      printTowers(towers)
      true
    }
    else false
  }
}
