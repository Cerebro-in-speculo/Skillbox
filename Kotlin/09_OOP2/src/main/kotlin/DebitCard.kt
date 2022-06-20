abstract class DebitCard(balanceDebit: DebitLimit) : BankCard() {
    override var balance: Balance = balanceDebit

    override fun topUp(money: Double) {
        balance.debitLimit += money
        println("Пополнение карты на $money руб.")
    }

    override fun pay(money: Double) = if (balance.debitLimit - money >= 0) {
        balance.debitLimit -= money
        println("Оплата с карты на $money руб.")
        true
    } else {
        println("Недовстаточно средств на карте. Списание на сумму $money руб. не прошло")
        false
    }

    override fun infoBalance() {
        println("Общий баланс - ${balance.debitLimit}")
    }

    override fun infoBalanceAll() {
        println("Дебитовый баланс карты - ${balance.debitLimit}")
        infoBalance()
    }

}