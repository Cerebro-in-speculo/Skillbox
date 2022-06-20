import kotlin.random.Random

class NatureReserve<T : Animal>(val animals: Map<String, MutableList<T>>) {

    var animalDiedCount = 0

    fun animalLifeDay(animal: MutableList<T>) {
        val newAnimal = mutableListOf<T>()
        animal.forEach {
            when (Random.nextInt(1, 5)) {
                1 -> it.move()
                2 -> it.eat()
                3 -> it.sleep()
                4 -> newAnimal.add(it.birthOfOffspring() as T)
            }
        }
        animal.addAll(newAnimal)
    }

    fun animalsInfoNatureReserve(animal: MutableList<T>) {
        animal.forEach { it.animalInfo() }
    }

    fun lifeOfAnimals(animal: MutableList<T>) {
        val animalLife = animal.filter { it.currentAge <= it.getMaximumAge() }
        val temp = animal.size - animalLife.size
        animal.clear()
        animal.addAll(animalLife)
        animalDiedCount += temp
    }
}
