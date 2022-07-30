class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge arrays into maxHeap
        //if (maxHeap.size() % 2 == 0) get element in middle and next element / 2
        //otherwise get middle element
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
        
        for(int i : nums1) maxHeap.add((double) i);
        
        for(int i : nums2) maxHeap.add((double) i);
        
        if(maxHeap.size() % 2 == 0) {
            int pos = (maxHeap.size() / 2) - 1;
        
            while(pos-- > 0) {
                maxHeap.poll();
            }
            
            return (maxHeap.poll() + maxHeap.poll()) / 2;
        } else {
            int pos = maxHeap.size() / 2;
            while(pos-- > 0) {
                maxHeap.poll();
            }
            return maxHeap.poll();
        }
    }
}