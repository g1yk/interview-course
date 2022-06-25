// https://leetcode.com/problems/design-hashmap/

public class LinearProbingHashTable<TKey, TValue> : HashTable<TKey, TValue> 
    where TKey: struct 
    where TValue: struct
{
    private const int INITIAL_CAPACITY = 4;
    private int count;
    private int capacity;
    private TKey?[] keys;
    private TValue?[] values;

    public LinearProbingHashTable(int capacity = INITIAL_CAPACITY)
    {
        this.count = 0;
        this.capacity = capacity;
        this.keys = new TKey?[capacity];
        this.values = new TValue?[capacity];
    }

    public void Put(TKey key, TValue val)
    {
        if (count >= capacity / 2) Resize(2 * capacity);
        int i;
        for (i = GetHash(key); keys[i] != null; i = (i + 1) % capacity)
        {
            if (keys[i]!.Equals(key)) break;
        }
        keys[i] = key;
        values[i] = val;
        count++;        
    }

    public TValue? Get(TKey key) {
        for (var i = GetHash(key); keys[i] != null; i = (i + 1) % capacity)
        {
            if (keys[i]!.Equals(key)) return values[i];
        }
        return null;
    }

    public void Remove(TKey key) {
        for (var i = GetHash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (!keys[i]!.Equals(key)) continue;
            keys[i] = null;
            values[i] = null;
            // rehash all keys in same cluster
            i = (i + 1) % capacity;
            while (keys[i] != null) 
            {
                var keyToRehash = keys[i];
                var valToRehash = values[i];
                keys[i] = null;
                values[i] = null;
                count--;
                Put((TKey)keyToRehash, (TValue)valToRehash);
                i = (i + 1) % capacity;
            }                    
            count--;
            break;
        }
        if (count > 0 && count <= capacity / 8) Resize(capacity / 2);
    }

    private int GetHash(TKey key) 
    {
        return (key.GetHashCode() & 0x7fffffff) % capacity;
    }

    private void Resize(int size) 
    {
        // rehash all keys
        var temp = new LinearProbingHashTable<TKey, TValue>(size);
        for (var i = 0; i < capacity; i++) 
        {
            if (keys[i] == null) continue;
            temp.Put((TKey)keys[i], (TValue)values[i]);
        }
        keys = temp.keys;
        values = temp.values;
        capacity = size;
    }
}
