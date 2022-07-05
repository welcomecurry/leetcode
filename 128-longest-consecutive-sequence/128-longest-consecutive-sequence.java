class Solution {
    public int longestConsecutive(int[] nums) {
        //base check if nums is empty return 0
        //add all nums to set
        //loop thorugh the set
        //if set does not contain num - 1 
        //***since we want to be at the beginning of a sequence*** IMPORTANT
        //set currentElement to num and  currentCount to 1
            //while set.contains(current element + 1)
            //count ++
            //currentElement++
        //take max of current length and current max
        //return maxlength
        
        if(nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums)
        {
            set.add(i);
        }
        
        int i = nums[0];
        int maxCount = 1;
        
        for(int num : set)
        {
            if(!set.contains(num - 1)) //we want to be at the beginning of a sequence
            {
                int currentCount = 1;
                int currentNum = num;
                    
                while(set.contains(currentNum + 1))
                {
                    currentCount++;
                    currentNum++;
                }
                
                maxCount = Math.max(maxCount, currentCount);
            }
        }
        
        return maxCount;
    }
}