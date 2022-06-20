fun main() {
    val natureReserve = NatureReserve(
        mapOf(
            "OtherAnimals" to
                    mutableListOf(
                        Animal(5, 6, 10, "Animal_1"),
                        Animal(5, 6, 10, "Animal_2"),
                        Animal(5, 6, 10, "Animal_3")
                    ),
            "Bird" to
                    mutableListOf(
                        Bird(3, 4, 12, "Bird_1"),
                        Bird(3, 4, 12, "Bird_2"),
                        Bird(3, 4, 12, "Bird_3"),
                        Bird(3, 4, 12, "Bird_4"),
                        Bird(3, 4, 12, "Bird_5")
                    ),
            "Fish" to
                    mutableListOf(
                        Fish(1, 2, 3, "Fish_1"),
                        Fish(1, 2, 3, "Fish_2"),
                        Fish(1, 2, 3, "Fish_3")
                    ),
            "Dog" to
                    mutableListOf(
                        Dog(2, 4, 11, "Dog_1"),
                        Dog(2, 4, 11, "Dog_2"),
                    )
        )
    )

    print("Ведите количество дней жизни животных в заповеднике: ")
    var n: Int? = readLine()?.toIntOrNull()
    while (n == null || n <= 0) {
        print("Количество дней введено не верно. Введите еще раз: ")
        n = readLine()?.toIntOrNull()
    }
    for (day in 1..n) {
        if (natureReserve.animals.all { it.value.isEmpty() }) {
            println("Все животные исчезли из зоопарка")
            break
        }
        println("\n******** День $day ********")
        natureReserve.animals.forEach { natureReserve.animalLifeDay(it.value) }
        natureReserve.animals.forEach { natureReserve.animalsInfoNatureReserve(it.value) }
        natureReserve.animals.forEach { natureReserve.lifeOfAnimals(it.value) }
    }
    println("Всего за $n дней умерло животных в зоопарке ${natureReserve.animalDiedCount}")
    println("В зоопарке через $n дней живет ${natureReserve.animals.values.sumOf { it.size }} животных")
}


