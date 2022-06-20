package Truck

enum class Truck(val tonnage: Int): Loading, Unloading {
    SMALL_TRUCK(20),
    MEDIUM_TRUCK(40),
    BIG_TRUCK(60)
}