class BonusesCcBank(val nameBank: String, balanceCredit: CreditLimit) : CreditCard(balanceCredit) {
    private var bonus = 0.0

    override fun pay(money: Double): Boolean {
        if (super.pay(money)) {
            bonus += money * 0.01
        }
        return false
    }

    override fun infoBalance() {
        println("Общий баланс $nameBank - ${balance.debitLimit + balance.creditLimit + bonus}")
    }

    override fun infoBalanceAll() {
        infoBalance()
        println("Дебитовый лимит карты - ${balance.debitLimit}")
        println("Кредитный лимит карты - ${balance.creditLimit}")
        println("Начислено бонусов с покупки - $bonus")
    }

}