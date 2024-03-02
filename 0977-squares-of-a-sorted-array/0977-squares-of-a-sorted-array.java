class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i : nums) minHeap.add(i * i);
        
        int index = 0;
        while(!minHeap.isEmpty()) output[index++] = minHeap.poll();
        
        return output;
    }
}