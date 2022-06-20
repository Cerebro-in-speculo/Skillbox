open class Stack<T>() {
    private var stack = mutableListOf<T>()

    fun push(item: T) {
        this.stack.add(item)
    }

    fun pop(): T? = stack.removeLastOrNull()

    fun isNotEmpty(): Boolean = stack.isNotEmpty()

    override fun toString(): String {
        val temp = mutableListOf<T>()
        for (item in stack) {
            temp.add(item)
        }
        return temp.joinToString(",")
    }
}