class DebitLimit(debit: Double = 0.0) : Balance() {
    override var debitLimit = debit
    override var creditLimit = 0.0
}