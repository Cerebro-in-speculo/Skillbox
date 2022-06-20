fun main() {
    print("Ведите n-е число из ряда Фибоначчи: ")
    var n: Int
    while (true) {
        n = readlnOrNull()?.toIntOrNull() ?: return
        if (n <= 0) {
            print("Число $n<=0. Введите число n еще раз: ")
            continue
        }
        break
    }
    println(myFibonacciFor(n))
    println(myFibonacciWhile(n))
    println(myFibonacciRec(n))
}

fun myFibonacciFor(n: Int): Long {
    var rez: Long = 0
    var n1: Long = 0
    var n2: Long = 1
    if (n == 1) return n1
    else if (n == 2) return n2
    else {
        for (i in 3..n) {
            rez = n1 + n2
            n1 = n2
            n2 = rez
        }
        return rez
    }
}

fun myFibonacciWhile(n: Int): Long {
    var rez: Long = 0
    var n1: Long = 0
    var n2: Long = 1
    var n = n
    if (n == 1) return n1
    else if (n == 2) return n2
    else {
        while (n >= 3) {
            rez = n1 + n2
            n1 = n2
            n2 = rez
            n--
        }
        return rez
    }
}

fun myFibonacciRec(n: Int): Long {
    if (n == 1) return 0
    else if (n in 1..2) return 1
    return myFibonacciRec(n - 1) + myFibonacciRec(n - 2)
}