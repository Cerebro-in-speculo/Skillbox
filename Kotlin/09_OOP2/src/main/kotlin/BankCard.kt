abstract class BankCard() {
    abstract var balance: Balance
    abstract fun topUp(money: Double)
    abstract fun pay(money: Double): Boolean
    abstract fun infoBalance()
    abstract fun infoBalanceAll()
}