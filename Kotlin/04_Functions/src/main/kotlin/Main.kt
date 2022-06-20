fun main() {
    val line1 = "F2p)v\"y233{0"
    val line2 = "->c}ttelciFc"

    println(firstPart(line1) + secondPart(line2))

}

fun firstPart(lineFirst: String): String {
    var temp = lineFirst.map { char -> char + 1 }.joinToString("")
    temp = temp.replace('5', 's')
    temp = temp.replace('4', 'u')
    temp = shift(temp, -3, myChange)
    temp = temp.replace('0', 'o')
    return temp
}

fun secondPart(lineSecond: String): String {
    var temp = lineSecond.reversed()
    temp = shift(temp, -4, myChange)
    temp = temp.replace('_', ' ')
    return temp
}

val myChange = { s: String, x: Int -> s.map { it + x }.joinToString("") }

fun shift(line: String, sh: Int, operation: (String, Int) -> String) = operation(line, sh)
