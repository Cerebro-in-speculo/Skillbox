import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
fun main() {
    val card1 = LottoCard()
    val card2 = LottoCard()
    val card3 = LottoCard()
    val player1 = Player("Roman", card1)
    val player2 = Player("Ivan", card2)
    val player3 = Player("Petr", card3)
    card1.createCard()
    card2.createCard()
    card3.createCard()

    var gameState: GameState = GameState.Progress
    var players = mutableListOf<Player>(player1, player2, player3)

    runBlocking {
        launch {
            println("Start game...")
            GeneratorKeg.getKeg().takeWhile { gameState is GameState.Progress }.collect {
                println("Keg value - $it")
                for (player in players) {
                    gameState = player.game(it)
                    if (gameState is GameState.Win)
                        break
                }
            }
            println(gameState)
        }
    }
    for (player in players)
        player.gameCard.printCard()
}

object GeneratorKeg {
    fun getKeg() = (1..90)
        .shuffled()
        .asFlow()
}