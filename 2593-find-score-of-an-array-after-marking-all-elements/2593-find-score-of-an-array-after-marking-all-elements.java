class Solution {
    public long findScore(int[] nums) {
        //create heap that holds elemnt and index and sort based on smallest index and mark array accordinly
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int i = 0; i < nums.length; i++) minHeap.add(new int[] {nums[i], i});
        
        long score = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int num = curr[0], index = curr[1];
            
            if(nums[index] == -1) continue;
            
            score += num;
            nums[index] = -1; //mark curr
            
            if(index - 1 >= 0) nums[index - 1] = -1; //mark left
            
            if(index + 1 < nums.length) nums[index + 1] = -1; //mark right
        }

        return score;
    }
}