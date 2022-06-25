// https://leetcode.com/problems/design-hashmap/

public interface HashTable<Key, Value> {
    fun put(key: Key, value: Value): Void
    fun get(key: Key): Value
    fun remove(key: Key): Void
}
