object Main extends App {
  var player1 = new Player("Player 1", true, false)
  var player2 = new Player("Player 2", true, false)

  val game = new TowerOfHanoi(false)
  game.setTower()

  do {
    val actualMove = player1.declareMove()
    println(actualMove)
  } while (true);

  println("Koniec gry! ")
}
