import kotlin.random.Random

open class Animal(
    private var energy: Int,
    private var weight: Int,
    protected val maximumAge: Int,
    protected val name: String
) {

    var currentAge: Int = 0

    open val move = "передвигается"

    fun sleep() {
        if (!isTooOld && this.weight != 0 && this.energy != 0) {
            this.energy += 5
            currentAge += 1
        }
        println("${this.name} спит")
    }

    fun eat() {
        if (!isTooOld && this.weight != 0 && this.energy != 0) {
            this.energy += 3
            this.weight += 1
            tryIncrementAge()
        }
        println("${this.name} ест")
    }

    open fun move() {
        if (!isTooOld && this.weight != 0 && this.energy != 0) {
            this.energy = if ((this.energy - 5) < 0) 0 else this.energy - 5
            this.weight = if ((this.weight - 1) < 0) 0 else this.weight - 1
            tryIncrementAge()
        }
        println("${this.name} ${this.move}")
    }

    private val isTooOld: Boolean
        get() = this.currentAge >= maximumAge

    private fun tryIncrementAge() {
        this.currentAge += if (Random.nextBoolean()) 1 else 0
    }

    fun animalInfo() {
        println("energy - $energy, weight - $weight, maximumAge - $maximumAge, name - $name, currentAge - $currentAge ")
    }

    @JvmName("getMaximumAge1")
    fun getMaximumAge() = this.maximumAge

    open fun birthOfOffspring(): Animal {
        println("${this.name} рожает")
        return Animal(
            energy = Random.nextInt(1, 10),
            weight = Random.nextInt(1, 5),
            maximumAge = this.maximumAge,
            name = this.name
        )
    }
}
