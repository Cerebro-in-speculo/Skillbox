fun main() {
    val rubUsd = Converters.get("USD")
    rubUsd.convertToRub(100.00)

    val rubEur = Converters.get("EUR")
    rubEur.convertToRub(100.00)

    val rubZwd = Converters.get("ZWD")
    rubZwd.convertToRub(100.00)

    val rubTky = Converters.get("TKY")
    rubTky.convertToRub(100.00)

    val rubAny = Converters.get("ANY")
    rubAny.convertToRub(100.00)
}