// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder() {
    val maxHeap = PriorityQueue<Int>()
    val minHeap = PriorityQueue<Int>(Collections.reverseOrder())
    
    fun addNum(num: Int) {
        if (maxHeap.size == minHeap.size) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll())
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll())
        }
    }

    fun findMedian(): Double {
        if (maxHeap.size == minHeap.size) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0 
        } else {
            return maxHeap.peek() * 1.0
        }
    }
}
