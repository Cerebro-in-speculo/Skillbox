object Weapons {
    fun createPistol() = object : AbstractWeapon(9, FireType.SingleShot) {
        override fun creatingAmmoType() = Ammo.STANDARD
    }

    fun createBazooka() = object : AbstractWeapon(2, FireType.SingleShot) {
        override fun creatingAmmoType() = Ammo.EXPLOSIVE
    }

    fun createMachineGun() = object : AbstractWeapon(2, FireType.FiringBursts(50)) {
        override fun creatingAmmoType() = Ammo.PIERCING
    }

    fun createMachine() = object : AbstractWeapon(2, FireType.FiringBursts(10)) {
        override fun creatingAmmoType() = Ammo.STANDARD
    }
}