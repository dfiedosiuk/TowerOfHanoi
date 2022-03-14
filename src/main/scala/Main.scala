object Main extends App {
  var player = new Player
  val game = new TowerOfHanoi(false)

  do {
    game.makeMove(game.towers, player)
  }while (!game.isFinished(game.towers));

  println("Wygrana! Koniec gry! ")
}
