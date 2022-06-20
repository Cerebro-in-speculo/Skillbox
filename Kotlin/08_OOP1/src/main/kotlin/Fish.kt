import kotlin.random.Random

class Fish(
    energy: Int,
    weight: Int,
    maximumAge: Int,
    name: String
) : Animal(energy, weight, maximumAge, name) {

    override val move = "плывет"

    override fun birthOfOffspring(): Fish {
        println("${this.name} рожает")
        return Fish(
            energy = Random.nextInt(1, 10),
            weight = Random.nextInt(1, 5),
            maximumAge = this.maximumAge,
            name = this.name
        )
    }

}