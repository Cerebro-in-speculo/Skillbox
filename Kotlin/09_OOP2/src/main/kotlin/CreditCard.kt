abstract class CreditCard(balanceCredit: CreditLimit) : BankCard() {

    override var balance: Balance = balanceCredit
    private val creditLimitSet = balance.creditLimit
    private var creditLimitUsed = 0.0

    override fun topUp(money: Double) {
        if (creditLimitUsed == 0.0) {
            balance.debitLimit += money
        } else {
            if (creditLimitUsed > money) {
                creditLimitUsed -= money
                balance.creditLimit += money
            } else if (creditLimitUsed < money) {
                balance.debitLimit += (money - creditLimitUsed)
                creditLimitUsed = 0.0
                balance.creditLimit = creditLimitSet
            } else {
                creditLimitUsed = 0.0
                balance.creditLimit = creditLimitSet
            }
        }
    }

    override fun pay(money: Double): Boolean {
        if (money > balance.debitLimit + balance.creditLimit) {
            println("Недовстаточно средств на карте. Остаток ${balance.debitLimit + balance.creditLimit} руб.")
            return false
        } else {
            if (money < balance.debitLimit) {
                balance.debitLimit -= money
            } else if (money > balance.debitLimit) {
                creditLimitUsed += (money - balance.debitLimit)
                balance.creditLimit -= creditLimitUsed
                balance.debitLimit = 0.0
            } else {
                balance.debitLimit = 0.0
            }
            return true
        }
    }

    override fun infoBalance() {
        println("Общий баланс - ${balance.debitLimit + balance.creditLimit}")
    }

    override fun infoBalanceAll() {
        println("Дебитовый лимит карты - ${balance.debitLimit}")
        println("Кредитный лимит карты - ${balance.creditLimit}")
        infoBalance()
    }

}