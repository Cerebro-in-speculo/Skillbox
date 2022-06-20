sealed class FireType {

    object SingleShot : FireType() //Одиночный выстрел
    data class FiringBursts(val queueSize: Int) : FireType() // Стрельба очередями
}
