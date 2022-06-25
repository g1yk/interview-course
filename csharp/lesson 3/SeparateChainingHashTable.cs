// https://leetcode.com/problems/design-hashmap/

public class SeparateChainingHashTable<TKey, TValue> : HashTable<TKey, TValue>
    where TKey : struct
    where TValue : struct 
{
    private const int INITIAL_CAPACITY = 4;
    private int count;
    private int capacity;
    private Node[] buckets;

    public SeparateChainingHashTable(int capacity = INITIAL_CAPACITY) 
    {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    public void Put(TKey key, TValue value) 
    {
        if (count >= 10 * capacity) Resize(2 * capacity);
        
        var i = GetHash(key);        
        for (var node = buckets[i]; node != null; node = node.next)
        {
            if (key.Equals(node.key)) 
            {
                node.value = value;
                return;
            }
        }
        buckets[i] = new Node(key, value, buckets[i]);
        count++;
    }

    public TValue? Get(TKey key) 
    {
        var i = GetHash(key);
        for (var node = buckets[i]; node != null; node = node.next) 
        {
            if (key.Equals(node.key)) return node.value;
        }
        return null;
    }

    public void Remove(TKey key) 
    {
        var i = GetHash(key);
        for (Node prev = null, node = buckets[i]; node != null; prev = node, node = node.next) 
        {
            if (key.Equals(node.key)) 
            {
                if (prev == null) 
                {
                    buckets[i] = node.next;
                } 
                else 
                {
                    prev.next = node.next;
                }
                count--;
                break;
            }
        }
        if (capacity > INITIAL_CAPACITY && count <= 2 * capacity) Resize(capacity / 2);
    }

    private int GetHash(TKey key) 
    {
        return (key.GetHashCode() & 0x7fffffff) % capacity;
    }

    private void Resize(int size) 
    {
        // rehash all keys
        var temp = new SeparateChainingHashTable<TKey, TValue>(size);
        foreach (var bucket in buckets) 
        {
            for (var node = bucket; node != null; node = node.next) 
            {
                temp.Put(node.key, node.value);
            }
        }
        this.buckets = temp.buckets;
        this.capacity = size;
    }

    private class Node
    {
        public TKey key;
        public TValue value;
        public Node next;

        public Node(TKey key, TValue value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
