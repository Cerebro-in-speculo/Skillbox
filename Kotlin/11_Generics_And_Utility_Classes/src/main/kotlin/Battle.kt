open class Battle(val firstTeam: MutableList<AbstractWarrior>, val secondTeam: MutableList<AbstractWarrior>) {
    private var isGameOver = true
    var steptempFirst = 0
    var steptempSecond = 0

    fun getProgress() {
        if (firstTeam.isNotEmpty() && secondTeam.isNotEmpty()) {
            println(
                BattleState.Progress(
                    Team().getHealth(firstTeam),
                    Team().getHealth(secondTeam),
                    firstTeam.size,
                    secondTeam.size
                ).toString()
            )
        } else if (firstTeam.isEmpty()) {
            println(BattleState.VictoryFirstTeam("Победила команда 2!!!").toString())
        } else if (secondTeam.isEmpty()) {
            println(BattleState.VictorySecondTeam("Победила команда 1!!!").toString())
        } else {
            println(BattleState.Draw("Ничья").toString())
        }
    }

    fun battle() {
        while (isGameOver) {
            getProgress()
            val tempFirstTeam = firstTeam.shuffled().toMutableList()
            val tempSecondTeam = secondTeam.shuffled().toMutableList()
            val warriorFirstTeam = tempFirstTeam[steptempFirst]
            val warriorSecondTeam = tempSecondTeam[steptempSecond]
            warriorFirstTeam.attack(warriorSecondTeam)
            warriorSecondTeam.attack(warriorFirstTeam)
            if (warriorFirstTeam.isKilled)
                tempFirstTeam.remove(warriorFirstTeam)
            if (warriorSecondTeam.isKilled)
                tempSecondTeam.remove(warriorSecondTeam)
            if (tempFirstTeam.isEmpty() || tempSecondTeam.isEmpty()) {
                updateTeam(tempFirstTeam, tempSecondTeam)
                break
            }
            updateTeam(tempFirstTeam, tempSecondTeam)

            if (steptempFirst >= tempFirstTeam.lastIndex)
                this.steptempFirst = 0
            else
                this.steptempFirst += 1

            if (steptempSecond >= tempSecondTeam.lastIndex)
                this.steptempSecond = 0
            else
                this.steptempSecond += 1
        }
        getProgress()
    }

    fun updateTeam(tempFirstTeam: MutableList<AbstractWarrior>, tempSecondTeam: MutableList<AbstractWarrior>) {
        firstTeam.clear()
        firstTeam.addAll(tempFirstTeam)
        secondTeam.clear()
        secondTeam.addAll(tempSecondTeam)
    }
}