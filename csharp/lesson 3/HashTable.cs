// https://leetcode.com/problems/design-hashmap/

public interface HashTable<TKey, TValue>
    where TKey : struct
    where TValue : struct 
{
    void Put(TKey key, TValue value);
    TValue? Get(TKey key);
    void Remove(TKey key);
}
