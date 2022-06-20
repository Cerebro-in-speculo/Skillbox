import kotlin.random.Random

class TV(val make: String, val model: String, val diagonalSize: Double) {

    var switch: Boolean = false
        private set

    var sound = Random.nextInt(0, maximumVolume)
        private set

    private val channelList = Channels.getRandomChannels(Channels.channelListAll)

    var channel: Pair<Int, String> = Pair(0, channelList[0])
        private set

    fun onOff() {
        this.switch = !this.switch
    }

    fun soundAdd(value: Int) {
        this.sound += value
        if (this.sound > maximumVolume) this.sound = maximumVolume
    }

    fun volumeSubtract(sound: Int) {
        this.sound -= sound
        if (this.sound < 0) this.sound = 0
    }

    fun channelSwitchingButton(button: Int) {
        if (!switch) {
            switch = true
        }
        if (button in 0..channelList.lastIndex)
            channel = Pair(button, channelList[button])
        else
            println("Данный канал не настроен на TV")
    }

    fun channelSwitchingUp() {
        if (!switch) {
            switch = true
        }

        channel = if (channel.first != channelList.lastIndex)
            Pair(channel.first + 1, channelList[channel.first + 1]) else Pair(0, channelList[0])
    }

    fun channelSwitchingDown() {
        if (!switch) {
            switch = true
        }
        channel = if (channel.first != 0)
            Pair(channel.first - 1, channelList[channel.first - 1]) else Pair(
            channelList.lastIndex, channelList[channelList.lastIndex]
        )
    }

    fun channelsInfo() {
        println("Текущие каналы:")
        channelList.forEachIndexed { it, _ -> println("$it - ${channelList[it]}") }
    }

    private companion object {
        var maximumVolume = 10
    }

    private object Channels {
        val channelListAll = listOf("ПЕРВЫЙ КАНАЛ", "РОССИЯ", "ТНТ", "СТС", "КУЛЬТУРА", "МТВ", "ДЕТСКИЙ", "5TV")
        fun getRandomChannels(channelListAll: List<String>): List<String> {
            val tempChannelList = channelListAll.shuffled()
            val tempSizeChannelList = Random.nextInt(0, channelListAll.lastIndex)
            val tempChannelMList = mutableListOf<String>()
            for (chl in 0..tempSizeChannelList) {
                tempChannelMList.add(tempChannelList[chl])
            }
            return tempChannelMList.toList()
            //return channelListAll.shuffled().subList(0,channelListAll.size)
        }
    }
}

