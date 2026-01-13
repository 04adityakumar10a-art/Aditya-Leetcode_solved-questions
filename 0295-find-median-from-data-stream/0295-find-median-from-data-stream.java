
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 class MedianFinder {
    PriorityQueue<Integer> minheap ;
    PriorityQueue<Integer> maxheap;
    public MedianFinder() {
         minheap =new PriorityQueue<>();
         maxheap =new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // Step 1: Insert into correct heap
        if (maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        // Step 2: Balance heaps
        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        }
        else if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
    public double findMedian() {
       if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else {
            return maxheap.peek();   // odd case
        }
    }

}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */