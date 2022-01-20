class Solution {
    public int splitArray(int[] nums, int m) {
        //binary search
        //set left to max of nums and right to sum of array
        //loop while left < rihgt
        //take sum (mid)
        //if we can split set right to sum
        //otherwise set left to. mid + 1
        //return right since it largest sum from m subarrays
        
        int left = 0, right = 0;
        
        for(int num : nums)
        {
            left = Math.max(left, num);
            right += num;
        }
        
        while(left < right)
        {
            int sum = left + (right - left) / 2;
            
            if(canSplit(nums, m, sum))
            {
                right = sum;
            }
            else
            {
                left = sum + 1;
            }
        }
        
        return right;
    }
    
    private boolean canSplit(int[] nums, int m, int sum)
    {
        int currSum = 0;
        int subarrays = 1;
        
        for(int num : nums)
        {
            if(currSum + num <= sum)
            {
                currSum += num;
                continue;
            }
            
            subarrays++;
            currSum = num;
        }
        
        return subarrays <= m;
    }
}