class Captain(
    maximumHealth: Int = 150,
    accuracy: Int = 20,
    weapon: AbstractWeapon = Weapons.createMachineGun(),
    currentHealth: Int = maximumHealth,
    evasion: Int = 20
) : AbstractWarrior(maximumHealth, accuracy, weapon, currentHealth, evasion) {

}