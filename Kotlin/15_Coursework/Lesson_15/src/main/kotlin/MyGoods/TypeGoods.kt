package MyGoods

enum class BigSizeGood (
    override val weight: Int,
    override val loadingTime: Int,
    override val unloadingTime: Int
) : PropertyGoods {
    CASK(30, 20, 15),
    TRAWL(50, 40, 30),
    FOREST(40, 60, 45)
}

enum class MediumSizedGood(
    override val weight: Int,
    override val loadingTime: Int,
    override val unloadingTime: Int
) : PropertyGoods {
    BOARD(20, 20, 15),
    WINDOW(15, 20, 10),
}

enum class SmallSizedGood(
    override val weight: Int,
    override val loadingTime: Int,
    override val unloadingTime: Int
) : PropertyGoods {
    CEMENT(20, 10, 5),
    STONE(15, 20, 10),
    SAND(20, 15, 5),
    WATER(10, 10, 10)
}

enum class FoodGood(
    override val weight: Int,
    override val loadingTime: Int,
    override val unloadingTime: Int
) : PropertyGoods {
    BREAD(5, 7, 3),
    MILK(4, 10, 7),
    POTATOES(30, 30, 30)
}



