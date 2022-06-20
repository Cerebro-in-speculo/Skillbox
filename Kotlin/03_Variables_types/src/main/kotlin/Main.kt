fun main() {
    val firstName: String = "Roman"
    val lastName: String = "Ledovskih"
    var height: Double = 174.0
    val weight: Float = 87.0f
    var isChild: Boolean = height < 150 || weight < 40
    var info: String = "My name-$firstName\nsurname-$lastName\nheight-$height\nweight-$weight\nisChild-$isChild"
    println(info)
    println()
    height = 210.5
    info = "My name-$firstName\nsurname-$lastName\nheight-$height\nweight-$weight\nisChild-$isChild"
    println(info)
    println()
    height = 140.0
    isChild = height < 150 || weight < 40
    info = "My name-$firstName\nsurname-$lastName\nheight-$height\nweight-$weight\nisChild-$isChild"
    println(info)
}