sealed class GameState {
    object Progress : GameState()

    data class Win(val player: Player) : GameState() {

        override fun toString(): String {
            return "Игрок ${player.namePlayer} победил"
        }
    }
}
