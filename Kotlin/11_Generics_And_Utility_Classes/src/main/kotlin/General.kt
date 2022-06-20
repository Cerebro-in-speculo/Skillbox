class General(
    maximumHealth: Int = 200,
    accuracy: Int = 30,
    weapon: AbstractWeapon = Weapons.createBazooka(),
    currentHealth: Int = maximumHealth,
    evasion: Int = 30
) : AbstractWarrior(maximumHealth, accuracy, weapon, currentHealth, evasion) {

}