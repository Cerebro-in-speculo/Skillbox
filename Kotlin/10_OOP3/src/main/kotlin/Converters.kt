object Converters {
    private val converters = listOf<CurrencyConverter>(Dollar(), Euro())

    fun get(currencyCode: String): CurrencyConverter {
        for (converter in converters) {
            if (converter.currencyCode == currencyCode)
                return converter
        }
        when (currencyCode) {
            "ZWD" ->
                return object : CurrencyConverter {
                    override val currencyCode: String = "ZWD"

                    override fun convertToRub(ruble: Double) {
                        println("$ruble рублей = ${ruble / 0.24} %$currencyCode%")
                    }
                }
            "TKY" ->
                return object : CurrencyConverter {
                    override val currencyCode: String = "TKY"

                    override fun convertToRub(ruble: Double) {
                        println("$ruble рублей = ${ruble / 5.59} %$currencyCode%")
                    }
                }
            else ->
                return object : CurrencyConverter {
                    override val currencyCode: String = ""

                    override fun convertToRub(ruble: Double) {
                        println("$ruble рублей не можем конвертировать!!!")
                    }
                }
        }
    }
}


