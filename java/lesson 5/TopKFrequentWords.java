// https://leetcode.com/problems/top-k-frequent-words

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, 1 + map.getOrDefault(word, 0));
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
            (a, b) -> a.getValue() != b.getValue() ? a.getValue().compareTo(b.getValue()) : b.getKey().compareTo(a.getKey())
        );
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) pq.poll();
        }
        
        LinkedList<String> result = new LinkedList<String>();
        while (!pq.isEmpty()) {            
            result.addFirst(pq.poll().getKey());
        }        
        
        return result;
    }
}
