class CashbackDcBank(val nameBank: String, balanceDebit: DebitLimit) : DebitCard(balanceDebit) {
    private var expenses = 0.0
    private var cashback = 0.0

    override fun pay(money: Double): Boolean {
        if (super.pay(money)) {
            expenses += money
            if (expenses >= 5000)
                cashback += money * 0.05
        }
        return false
    }

    override fun infoBalance() {
        println("Общий баланс $nameBank - ${balance.debitLimit + cashback}")
    }

    override fun infoBalanceAll() {
        infoBalance()
        println("Дебитовый баланс карты - ${balance.debitLimit}")
        println("Сумма начисленного cashback  - $cashback")
    }

}