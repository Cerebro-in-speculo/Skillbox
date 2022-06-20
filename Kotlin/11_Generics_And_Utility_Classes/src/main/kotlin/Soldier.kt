class Soldier(
    maximumHealth: Int = 100,
    accuracy: Int = 10,
    weapon: AbstractWeapon = Weapons.createMachine(),
    currentHealth: Int = maximumHealth,
    evasion: Int = 10
) : AbstractWarrior(maximumHealth, accuracy, weapon, currentHealth, evasion) {

}