// https://leetcode.com/problems/design-hashmap/

public class LinearProbingHashTable<Key, Value> implements HashTable<Key, Value> {
    private static final int INITIAL_CAPACITY = 4;
    private int count;
    private int capacity;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashTable() {
        this(INITIAL_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.keys = (Key[]) new Object[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value val) {
        if (count >= capacity / 2) resize(2 * capacity);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) break;
        }
        keys[i] = key;
        values[i] = val;
        count++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void remove(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (!keys[i].equals(key)) continue;
            keys[i] = null;
            values[i] = null;
            // rehash all keys in same cluster
            i = (i + 1) % capacity;
            while (keys[i] != null) {
                Key keyToRehash = keys[i];
                Value valToRehash = values[i];
                keys[i] = null;
                values[i] = null;
                count--;
                put(keyToRehash, valToRehash);
                i = (i + 1) % capacity;
            }
            count--;
            break;
        }
        if (count > 0 && count <= capacity / 8) resize(capacity / 2);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void resize(int size) {
        // rehash all keys
        LinearProbingHashTable<Key, Value> temp = new LinearProbingHashTable<Key, Value>(size);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] == null) continue;
            temp.put(keys[i], values[i]);
        }
        keys = temp.keys;
        values = temp.values;
        capacity = size;
    }
}
