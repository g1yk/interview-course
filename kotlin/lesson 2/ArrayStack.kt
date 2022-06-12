class ArrayStack<T>() : Stack<T> {
    var items = Array<Any?>(size = INITIAL_CAPACITY, { null }) as Array<T>
    var count = 0
    
    override fun push(value: T) {
        if (count == items.size) resize(items.size * 2)
        items[count] = value
        count++
    }
    
    override fun pop(): T {
        count--
        val result = items[count]
        if (count > 0 && count == items.size / 4) resize(items.size / 2)
        return result
    }	
    
    inline fun resize(size: Int) {
		val copy = Array<Any?>(size, { null }) as Array<T>
        for (i in 0..this.count) {
            copy[i] = items[i]
        }
        items = copy
    }
    
    companion object {
        const val INITIAL_CAPACITY = 2
	}
}
