import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.concurrent.thread

fun main() {
    runBlocking {

        val job = launch(Dispatchers.Default) {
            try {
                withTimeout(3000) {
                    while (true) {
                        yield()
                        println(Fibonacci.take(4))
                    }
                }
            } catch (e: TimeoutCancellationException) {
                println("Превышении времени вычисления")
            }
        }

        launch {
            delay(5000)
            println("cancel job")
            job.cancel()
            job.join()
        }

        launch { println(Fibonacci.take(5)) }
        launch { println(Fibonacci.take(6)) }
        launch { println(Fibonacci.take(7)) }
    }
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        var rez = BigInteger("0")
        var n1 = BigInteger("0")
        var n2 = BigInteger("1")
        delay(500)
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
}
