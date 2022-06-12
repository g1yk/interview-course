class LinkedListStack<T> : Stack<T> {
    var head: Node<T>? = null
    
    override fun push(value: T) {
        head = Node(value, head)
    }

    override fun pop(): T {
        val result = head?.value ?: throw Exception("Stack is empty")
        head = head?.next
        return result
    }
}
