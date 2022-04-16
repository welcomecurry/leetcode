class Solution {
    public int maximumProduct(int[] nums, int k) {
        //init minheap
        //add all nums
        //while k > 0
        //increment current poll and back into heap
        //take product and return
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums) minHeap.add(num);
        
        while(k-- > 0)
        {
            minHeap.add(minHeap.poll() + 1);
        }
        
        long prod = 1;
        
        while(!minHeap.isEmpty()) 
        {
            prod = (prod * minHeap.poll()) % 1000000007;
        }
        
        return (int) prod;
    }
}