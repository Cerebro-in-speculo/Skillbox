abstract class AbstractWarrior(
    val maximumHealth: Int,
    val accuracy: Int,
    val weapon: AbstractWeapon,
    var currentHealth: Int,
    override val evasion: Int
) : Warrior {

    override val isKilled: Boolean
        get() = currentHealth == 0

    override fun attack(enemy: Warrior) {
        if (!weapon.isAmmoMagazine) {
            weapon.rechargeMagazine()
        } else {
            val ammo = weapon.getAmmoShot()
            if (accuracy > enemy.evasion) {
                val allDamage: Int = ammo.sumOf { it.getDamage() }
                enemy.takeDamage(allDamage)
            }
        }
    }

    override fun takeDamage(damage: Int) {
        if (this.currentHealth - damage < 0)
            this.currentHealth = 0
        else this.currentHealth -= damage
    }
}