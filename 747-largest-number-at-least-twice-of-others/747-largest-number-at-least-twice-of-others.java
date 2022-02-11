class Solution {
    public int dominantIndex(int[] nums) {
        //base case if nums.length == 1
        //add pair of num and index into heap
        //sort by max
        //poll off 2 maxes and if second max is > max return indice otherwise -1
        
        if(nums.length == 1) return 0;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i = 0; i < nums.length; i++) maxHeap.add(new int[] {nums[i], i});
        
        int[] max = maxHeap.poll();
        int[] secondMax = maxHeap.poll();
        
        return max[0] >= (secondMax[0] * 2) ? max[1] : -1;
    }
}