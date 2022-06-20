class DepositCcBank(val nameBank: String, balanceCredit: CreditLimit) : CreditCard(balanceCredit) {
    private var deposit = 0.0

    override fun topUp(money: Double) {
        super.topUp(money)
        deposit += money * 0.00005
    }

    override fun infoBalance() {
        println("Общий баланс $nameBank - ${balance.debitLimit + balance.creditLimit + deposit}")
    }

    override fun infoBalanceAll() {
        infoBalance()
        println("Дебитовый лимит карты - ${balance.debitLimit}")
        println("Кредитный лимит карты - ${balance.creditLimit}")
        println("Сумма накопленного депозита от пополнения - $deposit")
    }

}