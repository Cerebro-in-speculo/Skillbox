class Euro : CurrencyConverter {
    override val currencyCode: String = "EUR"

    override fun convertToRub(ruble: Double) {
        println("$ruble рублей = ${ruble / 88.5} %$currencyCode%")
    }
}