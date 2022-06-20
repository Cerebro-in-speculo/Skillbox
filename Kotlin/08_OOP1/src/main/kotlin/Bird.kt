import kotlin.random.Random

class Bird(
    energy: Int,
    weight: Int,
    maximumAge: Int,
    name: String
) : Animal(energy, weight, maximumAge, name) {

    override val move = "летит"

    override fun birthOfOffspring(): Bird {
        println("${this.name} рожает")
        return Bird(
            energy = Random.nextInt(1, 10),
            weight = Random.nextInt(1, 5),
            maximumAge = this.maximumAge,
            name = this.name
        )
    }
}