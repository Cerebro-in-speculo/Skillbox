import kotlin.random.Random

enum class Ammo(
    private val damage: Int,
    private val criticalDamageChance: Int,
    private val criticalDamageCoefficient: Int
) {
    STANDARD(10, 15, 2),// Стандартные патроны
    PIERCING(20, 25, 3),// Проникающие патроны
    EXPLOSIVE(50, 5, 4);// Разрывные патроны


    fun getDamage(): Int = if (criticalDamageChance.criticalDamage()) damage * criticalDamageCoefficient else damage

    //Функция расширения критического урона
    private fun Int.criticalDamage() = this > Random.nextInt(1, 100)
}