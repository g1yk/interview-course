public class SeparateChainingHashTable<Key, Value> implements HashTable<Key, Value> {
    private static final int INITIAL_CAPACITY = 4;
    private int count;
    private int buckets;
    private Node<Key, Value>[] items;

    public SeparateChainingHashTable() {
        this(INITIAL_CAPACITY);
    }

    public SeparateChainingHashTable(int buckets) {
        this.buckets = buckets;
        this.items = (Node<Key, Value>[]) new Node[buckets];
    }

    public void put(Key key, Value value) {
        if (count >= 10 * buckets) resize(2 * buckets);
        int i = hash(key);
        for (Node<Key, Value> node = items[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        items[i] = new Node<Key, Value>(key, value, items[i]);
        count++;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node<Key, Value> node = items[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return (Value) node.value;
            }
        }
        return null;
    }

    public void remove(Key key) {
        int i = hash(key);
        if (items[i] == null) return;

        for (Node prev = null, node = items[i]; node != null; prev = node, node = node.next) {
            if (key.equals(node.key)) {
                if (prev == null) {
                    items[i] = node.next;
                } else {
                    prev.next = node.next;
                }
                count--;
                break;
            }
        }
        if (buckets > INITIAL_CAPACITY && count <= 2 * buckets) resize(buckets / 2);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

    private void resize(int size) {
        SeparateChainingHashTable<Key, Value> temp = new SeparateChainingHashTable<Key, Value>(size);
        for (Node<Key, Value> item : items) {
            for (Node<Key, Value> node = item; node != null; node = node.next) {
                temp.put(node.key, node.value);
            }
        }
        this.items = temp.items;
        this.buckets = size;
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
