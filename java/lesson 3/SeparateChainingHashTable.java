// https://leetcode.com/problems/design-hashmap/

public class SeparateChainingHashTable<Key, Value> implements HashTable<Key, Value> {
    private static final int INITIAL_CAPACITY = 4;
    private int count;
    private int capacity;
    private Node<Key, Value>[] buckets;

    public SeparateChainingHashTable() {
        this(INITIAL_CAPACITY);
    }

    public SeparateChainingHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<Key, Value>[]) new Node[capacity];
    }

    public void put(Key key, Value value) {
        if (count >= 10 * capacity) resize(2 * capacity);
        int i = hash(key);
        for (Node<Key, Value> node = buckets[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        buckets[i] = new Node<Key, Value>(key, value, buckets[i]);
        count++;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node<Key, Value> node = buckets[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(Key key) {
        int i = hash(key);
        if (buckets[i] == null) return;

        for (Node prev = null, node = buckets[i]; node != null; prev = node, node = node.next) {
            if (key.equals(node.key)) {
                if (prev == null) {
                    buckets[i] = node.next;
                } else {
                    prev.next = node.next;
                }
                count--;
                break;
            }
        }
        if (capacity > INITIAL_CAPACITY && count <= 2 * capacity) resize(capacity / 2);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void resize(int size) {
        SeparateChainingHashTable<Key, Value> temp = new SeparateChainingHashTable<Key, Value>(size);
        for (Node<Key, Value> item : buckets) {
            for (Node<Key, Value> node = item; node != null; node = node.next) {
                temp.put(node.key, node.value);
            }
        }
        this.buckets = temp.buckets;
        this.capacity = size;
    }

    private class Node<Key, Value> {
        public Key key;
        public Value value;
        public Node<Key, Value> next;

        public Node(Key key, Value value, Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
