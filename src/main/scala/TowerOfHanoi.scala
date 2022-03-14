import scala.collection.mutable
import scala.io.StdIn.readLine

class TowerOfHanoi(var isGameFinished: Boolean) {

  def setTower(): Array[mutable.Stack[Int]]={
    var rings = 0
    do{
      rings = readLine("Podaj ilosc dyskow (od 3 do 8):  ").toInt
    }while(3 to 8 contains(response))
    val Towers = Array(mutable.Stack[Int]()pushAll(rings to 0 by -1), mutable.Stack[Int](), mutable.Stack[Int]())
    Towers
  }

  def makeMove()


}
