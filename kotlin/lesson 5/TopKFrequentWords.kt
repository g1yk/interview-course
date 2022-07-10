// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freq = mutableMapOf<String, Int>()
        for (word in words) {
            freq[word] = freq.getOrDefault(word, 0) + 1
        }

       val pq = PriorityQueue<Map.Entry<String, Int>>(
           Comparator { a, b -> if (a.value != b.value) a.value.compareTo(b.value) else b.key.compareTo(a.key) }
       )

        freq.forEach {
            pq.offer(it)
            if (pq.size > k) pq.poll()
        }
        
        val result = LinkedList<String>()
        while (!pq.isEmpty()) {
            result.addFirst(pq.poll().key)
        }

        return result
    }
}
