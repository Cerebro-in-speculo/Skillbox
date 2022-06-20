import kotlin.random.Random

class Dog(
    energy: Int,
    weight: Int,
    maximumAge: Int,
    name: String
) : Animal(energy, weight, maximumAge, name) {

    override val move = "бежит"

    override fun birthOfOffspring(): Dog {
        println("${this.name} рожает")
        return Dog(
            energy = Random.nextInt(1, 10),
            weight = Random.nextInt(1, 5),
            maximumAge = this.maximumAge,
            name = this.name
        )
    }
}