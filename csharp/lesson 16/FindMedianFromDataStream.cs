// https://leetcode.com/problems/find-median-from-data-stream/

public class MedianFinder {
    private PriorityQueue<int, int> maxHeap = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => b.CompareTo(a)));
    private PriorityQueue<int, int> minHeap = new PriorityQueue<int, int>();
    
    
    public void AddNum(int num) {
        if (maxHeap.Count == minHeap.Count) {
            minHeap.Enqueue(num, num);
            maxHeap.Enqueue(minHeap.Peek(), minHeap.Dequeue());
        } else {
            maxHeap.Enqueue(num, num);
            minHeap.Enqueue(maxHeap.Peek(), maxHeap.Dequeue());            
        }
    }
    
    public double FindMedian() {
         return maxHeap.Count == minHeap.Count
            ? (minHeap.Peek() + maxHeap.Peek()) / 2.0
            : maxHeap.Peek();
    }
}
