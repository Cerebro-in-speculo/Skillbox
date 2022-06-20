class Recruit(
    maximumHealth: Int = 50,
    accuracy: Int = 5,
    weapon: AbstractWeapon = Weapons.createPistol(),
    currentHealth: Int = maximumHealth,
    evasion: Int = 5
) : AbstractWarrior(maximumHealth, accuracy, weapon, currentHealth, evasion) {

}