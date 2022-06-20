fun main() {
    val wheel = Wheel()

    try {
        //wheel.pumpWheel(-5.0)
        //wheel.pumpWheel(6.0)
        //wheel.pressureСheck()
        wheel.pumpWheel(1.0)
        wheel.pressureСheck()
        wheel.pumpWheel(2.0)
        wheel.pressureСheck()
    } catch (t: TooHighPressure) {
        println(t.message)
    } catch (t: TooLowPressure) {
        println(t.message)
    } catch (t: IncorrectPressure) {
        println(t.message)
    }
}

class TooHighPressure : Throwable(message = "Эксплуатация невозможна — давление превышает нормальное.")
class TooLowPressure : Throwable(message = "Эксплуатация невозможна — давление ниже нормального.")
class IncorrectPressure : Throwable(message = "Процедура не удалась")

class Wheel {
    private var currentPressure: Double = 0.0

    fun pumpWheel(pressure: Double) {
        val tempPressure = this.currentPressure + pressure
        if (tempPressure < 0.0 || tempPressure > 10.0)
            throw IncorrectPressure()
        else {
            println("Процедура удалась.")
            this.currentPressure = tempPressure
        }
    }

    fun pressureСheck() {
        when {
            this.currentPressure >= 0.0 && this.currentPressure < 1.6 -> throw TooLowPressure()
            this.currentPressure > 2.5 && this.currentPressure <= 10.0 -> throw TooHighPressure()
            else -> println("Эксплуатация возможна.")
        }
    }
}
