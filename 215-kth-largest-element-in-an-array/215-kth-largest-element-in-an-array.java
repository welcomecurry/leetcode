class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i : nums) maxHeap.add(i);
        
        while(k-- > 1) maxHeap.poll();
        
        return maxHeap.poll();
    }
}