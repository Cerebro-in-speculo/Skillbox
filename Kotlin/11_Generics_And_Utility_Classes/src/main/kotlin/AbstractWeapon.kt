abstract class AbstractWeapon(val maximumAmmo: Int, val typeShooting: FireType) {

    var magazineAmmo = Stack<Ammo>() // Магазин патронов
    val isAmmoMagazine: Boolean // Факт наличия патронов в магазине
        get() = magazineAmmo.isNotEmpty()

    abstract fun creatingAmmoType(): Ammo// Cоздание патрона необходимого типа

    fun rechargeMagazine() {
        val newMagazineAmmo = Stack<Ammo>()
        repeat(maximumAmmo) {
            newMagazineAmmo.push(creatingAmmoType())
        }
        magazineAmmo = newMagazineAmmo
    } // Перезарядка магазина

    fun getAmmoShot(): List<Ammo> {
        val ammo = mutableListOf<Ammo>()
        if (typeShooting is FireType.FiringBursts) {
            repeat(typeShooting.queueSize) {
                if (!isAmmoMagazine)
                    return ammo.toList()
                ammo.add(magazineAmmo.pop() ?: return ammo.toList())
            }
            return ammo.toList()
        } else {
            if (!isAmmoMagazine)
                return ammo.toList()
            ammo.add(magazineAmmo.pop() ?: return ammo.toList())
            return ammo.toList()
        }
    }// Получение патронов для выстрела
}