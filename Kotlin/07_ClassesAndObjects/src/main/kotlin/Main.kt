fun main() {

    val store = listOf<TV>(
        TV("Марка1", "Модель1", 23.0),
        TV("Марка2", "Модель2", 30.0),
        TV("Марка3", "Модель3", 17.0),
        TV("Марка4", "Модель4", 57.0),
        TV("Марка5", "Модель5", 120.0),
    )
    storeInfoTest(store)
}

fun storeInfoTest(store: List<TV>) {
    for (tv in 0..store.lastIndex) {
        println("\n*** Тестирование телевизора #${tv + 1} ***")

        println("Статус телевизора - ${if (store[tv].switch)"Включен" else "Выключен"}")
        println("Тест 1. Вывод информации о телевизире:")
        println("Марка - ${store[tv].make}, модель - ${store[tv].model}, диагональ - ${store[tv].diagonalSize}")

        println("\nТест 2. Проверка функции громкости:")
        println("Проверка громкости:")
        println("Текущая громкость - ${store[tv].sound}")
        store[tv].soundAdd(3)
        println("Увеличение громкости на 3 деления - текущая громкость ${store[tv].sound}}")
        store[tv].volumeSubtract(4)
        println("уменьшение громкости на 4 деления - текущая громкость ${store[tv].sound}")

        println("\nТест 3. Проверка переключения каналов по кнопке:")
        store[tv].channelsInfo()
        println("Проверим кнопку 3:")
        store[tv].channelSwitchingButton(3)
        println("Переключение на канал ${store[tv].channel}")

        println("\nТест 4. Проверка переключения каналов по стрелке UP/DOWN:")
        store[tv].channelSwitchingUp()
        store[tv].channelSwitchingUp()
        store[tv].channelSwitchingUp()
        println("Нажитие кнопки UP 3 раза:")
        println("Переключение на канал ${store[tv].channel}")
        println("Нажитие кнопки DOWN 2 раза:")
        store[tv].channelSwitchingDown()
        store[tv].channelSwitchingDown()
        println("Переключение на канал ${store[tv].channel}")
        println("Статус телевизора - ${if (store[tv].switch)"Включен" else "Выключен"}")
        println("Выключим телевизор")
        store[tv].onOff()
        println("Статус телевизора - ${if (store[tv].switch)"Включен" else "Выключен"}")
        println("********************************************")
    }
}


