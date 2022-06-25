// https://leetcode.com/problems/design-hashmap/

public class SeparateChainingHashTable<Key, Value>(var capacity: Int = INITIAL_CAPACITY) : HashTable<Key, Value> {
            
    private var count = 0
    private var buckets = Array<Node<Key,Value>?>(capacity, { null })

    override fun put(key: Key, value: Value) {
        if (count >= 10 * capacity) resize(2 * capacity)
        var i = hash(key)
        var node = buckets[i]
        while (node != null) {
            if (key == node.key) {
                node.value = value
                return
            }
            node = node.next
        }        
        buckets[i] = Node<Key, Value>(key, value, buckets[i])
        count++
    }

    override fun get(key: Key): Value? {
        var node = buckets[hash(key)]
        while (node != null) {
            if (key == node.key) return node.value
            node = node.next
        }        
        return null
    }

    override fun remove(key: Key) {
        var i = hash(key)        
        if (buckets[i] == null) return
        var prev: Node<Key, Value>? = null
        var node = buckets[i]        
        while (node != null) {
            if (key == node.key) {
                if (prev == null) {
                    buckets[i] = node.next
                } else {
                    prev.next = node.next
                }
                count--
                break
            }            
            prev = node
            node = node.next
        }
        
        if (capacity > INITIAL_CAPACITY && count <= 2 * capacity) resize(capacity / 2)
    }

    private fun hash(key: Key): Int {
        return key.hashCode() % capacity
    }

    private fun resize(size: Int) {
        val temp = SeparateChainingHashTable<Key, Value>(size)
        for (bucket in buckets) {
            var node = bucket
            while (node != null) {
                temp.put(node.key, node.value)
                node = node.next
            }
        }
        this.buckets = temp.buckets
        this.capacity = size
    }

    companion object {
        const val INITIAL_CAPACITY = 4
    }
    
    class Node<Key, Value>(var key: Key, var value: Value, var next: Node<Key, Value>? = null)
}
