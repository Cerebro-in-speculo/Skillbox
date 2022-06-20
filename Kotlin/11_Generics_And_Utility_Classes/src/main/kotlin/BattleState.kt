sealed class BattleState {

    class Progress(
        private val totalHealthFirstTeam: Int,
        private val totalHealthSecondTeam: Int,
        private val allWarriorsFirstTeam: Int,
        private val allWarriorsSecondTeam: Int
    ) : BattleState() {
        override fun toString(): String {
            return ("""
                |Cуммарное здоровье команды 1: $totalHealthFirstTeam
                |Количество войнов в 1 команде: $allWarriorsFirstTeam
                |Cуммарное здоровье команды 2: $totalHealthSecondTeam
                |Количество войнов во 2 команде: $allWarriorsSecondTeam
                |
            """.trimMargin())
        }
    }

    class VictoryFirstTeam(val victoryFirstTeam: String) : BattleState() {
        override fun toString(): String {
            return victoryFirstTeam
        }
    }

    class VictorySecondTeam(val victorySecondTeam: String) : BattleState() {
        override fun toString(): String {
            return victorySecondTeam
        }

    }

    class Draw(val draw: String) : BattleState() {
        override fun toString(): String {
            return draw
        }
    }

}
