class Solution {
    public long findScore(int[] nums) {
        //create heap that holds elemnt and index and sort based on smallest index and mark array accordinly
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int i = 0; i < nums.length; i++) minHeap.add(new int[] {nums[i], i});
        
        long score = 0, marked = 0;
                System.out.println(minHeap.size());

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            System.out.println(curr[0] +" "+ curr[1] + " "+ marked);
            int num = curr[0], index = curr[1];
            if(nums[index] == -1) continue;
            score += num;
            nums[index] = -1; //mark curr
            marked++;
            if(index - 1 >= 0) {
                nums[index - 1] = -1; //mark left
                marked++;
            }
            
            if(index + 1 < nums.length) {
                
                nums[index + 1] = -1; //mark right
                marked++;
            }
        }

        return score;
    }
}