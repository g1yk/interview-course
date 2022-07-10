// https://leetcode.com/problems/top-k-frequent-words

public class Solution
{
    public IList<string> TopKFrequent(string[] words, int k)
    {
        var freq = new Dictionary<string, int>();
        foreach (var s in words)
        {
            freq[s] = freq.GetValueOrDefault(s, 0) + 1;
        }

        var pq = new PriorityQueue<string, KeyValuePair<string, int>>(Comparer<KeyValuePair<string, int>>.Create((x, y) =>
                        (x.Value == y.Value) ? (y.Key.CompareTo(x.Key)) : (x.Value - y.Value)));

        foreach (var entry in freq)
        {
            pq.Enqueue(entry.Key, entry);
            if (pq.Count > k)
            {
                pq.Dequeue();
            }
        }

        var result = new string[pq.Count];
        for (var i = result.Count - 1; i >= 0; i--)
        {
            result[i] = pq.Dequeue();
        }
        return result;
    }
}
