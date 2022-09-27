// https://leetcode.com/problems/lru-cache/

class LRUCache(private val capacity: Int) {
    val map = mutableMapOf<Int, Node>()
    val list = DoubleLinkedList()
    
    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        list.moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map[key] == null) {
            val node = Node(key, value)
            map[key] = node
            list.addToHead(node)
            if (map.size > capacity) {
                list.removeFromTail()?.let { 
                    removed -> map.remove(removed.key)
                }
            }
        } else {
            map[key]?.let { node ->
                node.value = value
                list.moveToHead(node)    
            }         
        }
    }    
    
    class DoubleLinkedList {
        val head = Node(0,0)
        val tail = Node(0,0)

        init {
            head.prev = tail
            tail.next = head
        }
         
        fun removeFromTail(): Node? {
            val node = tail.next
            tail.next = node?.next
            node?.next?.prev = tail
            node?.next = null
            node?.prev = null
            return node
        }

        fun moveToHead(node: Node) {
            val prev = node.prev
            val next = node.next
            prev?.next = next
            next?.prev = prev
            addToHead(node) 
        }

        fun addToHead(node: Node) {
            val prev = head.prev
            prev?.next = node
            node?.prev = prev
            node?.next = head
            head?.prev = node
        }
    }
    
    data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )    
}
