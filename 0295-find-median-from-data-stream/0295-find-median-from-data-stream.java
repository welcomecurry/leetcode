class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minNums;
    PriorityQueue<Integer> maxNums;
    boolean even;
    public MedianFinder() {
        //keep two balanced halfs
        minNums = new PriorityQueue<>(Collections.reverseOrder());
        maxNums = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        //add to maxHeap and then balance heaps
        minNums.add(num);
        maxNums.add(minNums.poll());
        
        if(maxNums.size() > minNums.size()) {
            minNums.add(maxNums.poll());
        }
        
        even = !even;
    }
    
    public double findMedian() {
        //if even return min and max peak / 2
        //else return middle number in maxHeap
        if(even) {
            return (minNums.peek() + maxNums.peek()) / 2.0;
        }
        
        return minNums.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */