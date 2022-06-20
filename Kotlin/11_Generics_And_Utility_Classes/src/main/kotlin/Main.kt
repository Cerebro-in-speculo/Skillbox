import kotlin.random.Random

fun main() {
    val firstTeam = Team().addArmy(addNumberWarriors())
    val secondTeam = Team().addArmy(addNumberWarriors())
    println(firstTeam)
    println(secondTeam)
    val battle = Battle(firstTeam, secondTeam)
    battle.battle()

}

fun addNumberWarriors(): Int { // Ввод количества войнов в команде
    print("Ведите количество войнов: ")
    var n: Int?
    while (true) {
        n = readlnOrNull()?.toIntOrNull()
        if (n == null) {
            print("Количество войнов введено некорректно. Введите еще раз: ")
            continue
        } else if (n <= 0) {
            print("Количество войнов не введено: ")
            continue
        }
        return n
    }
}