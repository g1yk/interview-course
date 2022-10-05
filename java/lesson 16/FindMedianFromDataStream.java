// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    private PriorityQueue<Integer>  minHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());            
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());            
        }
    }
    
    public double findMedian() {
        return maxHeap.size() == minHeap.size() 
            ? (minHeap.peek() + maxHeap.peek()) / 2.0
            : maxHeap.peek();
    }
}
