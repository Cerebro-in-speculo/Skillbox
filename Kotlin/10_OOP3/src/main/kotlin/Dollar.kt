class Dollar : CurrencyConverter {
    override val currencyCode: String = "USD"

    override fun convertToRub(ruble: Double) {
        println("$ruble рублей = ${ruble / 75.5} %$currencyCode%")
    }
}