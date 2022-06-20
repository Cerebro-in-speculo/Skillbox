fun main() {
    print("Ведите количество телефонных номеров N в справочник: ")
    var n: Int?
    n = readLine()?.toIntOrNull()
    while (n == null || n <= 0) {
        print("Число n<0 или введено некорректно. Введите число N еще раз: ")
        n = readLine()?.toIntOrNull()
    }

    val myDirectoryPhone = addMyDirectoryPhone(n)
    println(myDirectoryPhone.filter { it[0] == '+' && it[1] == '7' }.joinToString())
    println(myDirectoryPhone.toSet().size)
    println(myDirectoryPhone.sumOf { it.length })

    val myDirectory = addMyDirectoryName(myDirectoryPhone)
    println("Без сортировки:")
    myDirectory.forEach { (k, v) -> println("Абонент: $v. Номер телефона: $k") }
    println("Сортировка по номеру телефона:")
    myDirectory.toSortedMap().forEach { (k, v) -> println("Абонент: $v. Номер телефона: $k") }
    println("Сортировка по имени абонента:")
    myDirectory.toSortedMap().toList().sortedBy { it.second }
        .forEach { (k, v) -> println("Абонент: $v. Номер телефона: $k") }
}

fun addMyDirectoryPhone(n: Int): List<String> {
    val directoryPhone = mutableListOf<String>()
    println("Введите $n номеров телефонов в справочник")
    for (i in 1..n) {
        directoryPhone.add(readLine().toString())
    }
    return directoryPhone.toList()
}

fun addMyDirectoryName(name: List<String>): Map<String, String> {
    val directoryName = mutableMapOf<String, String>()
    val nameSet = name.toSet()
    println("Введите ${nameSet.size} имен для справочника:")
    nameSet.forEach { directoryName[it] = readLine().toString() }
    return directoryName.toMap()
}

