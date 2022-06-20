import kotlin.random.Random

class Team() {

    fun addArmy(number: Int): MutableList<AbstractWarrior> {
        val teamWarriors = mutableListOf<AbstractWarrior>()
        val probability = Random.nextInt(0, 101)
        for (item in 0 until number) {
            when (probability) {
                in 0..10 -> {
                    teamWarriors.add(General())
                    continue
                }
                in 0..30 -> {
                    teamWarriors.add(Captain())
                    continue
                }
                in 0..50 -> {
                    teamWarriors.add(Soldier())
                    continue
                }
                else -> teamWarriors.add(Recruit())
            }
        }
        return teamWarriors
    }

    fun getHealth(teame: MutableList<AbstractWarrior>) = teame.sumOf { it.currentHealth }
}