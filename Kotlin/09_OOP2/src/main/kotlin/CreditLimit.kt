class CreditLimit(debit: Double = 0.0, credit: Double = 0.0) : Balance() {
    override var debitLimit = debit
    override var creditLimit = credit
}