// https://leetcode.com/problems/design-hashmap/

public class LinearProbingHashTable<Key, Value>(var capacity: Int = INITIAL_CAPACITY) : HashTable<Key, Value> {
            
    private var count = 0
    private var keys = Array<Any?>(capacity, { null }) as Array<Key?>
    private var values = Array<Any?>(capacity, { null }) as Array<Value?>

    override fun put(key: Key, value: Value) {
        if (count >= capacity / 2) resize(2 * capacity)
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i] == key) break
            i = (i + 1) % capacity
        }
        keys[i] = key
        values[i] = value
        count++
    }

    override fun get(key: Key): Value? {
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i] == key) return values[i]
            i = (i + 1) % capacity
        }
        return null
    }

    override fun remove(key: Key) {
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i] != key) {
                i = (i + 1) % capacity
                continue
            }
            keys[i] = null
            values[i] = null
            // rehash all keys in same cluster
            i = (i + 1) % capacity
            while (keys[i] != null) {
                val keyToRehash = keys[i]
                val valToRehash = values[i]
                keys[i] = null
                values[i] = null
                count--
                put(keyToRehash!!, valToRehash!!)
                i = (i + 1) % capacity
            }
            count--
            break
        }
        if (count > 0 && count <= capacity / 8) resize(capacity / 2)
    }

    private fun hash(key: Key): Int {
        return key.hashCode() % capacity
    }

    private fun resize(size: Int) {
        // rehash all keys
        val temp = LinearProbingHashTable<Key, Value>(size)
        for (i in 0..capacity-1) {
            if (keys[i] == null) continue
            temp.put(keys[i]!!, values[i]!!)
        }
        keys = temp.keys
        values = temp.values
        capacity = size
    }

    companion object {
        const val INITIAL_CAPACITY = 4
    }
}
