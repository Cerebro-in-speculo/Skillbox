interface Warrior {
    val isKilled: Boolean
    val evasion: Int//Шанс избежать попадания.

    fun attack(enemy: Warrior)
    fun takeDamage(damage: Int)
}