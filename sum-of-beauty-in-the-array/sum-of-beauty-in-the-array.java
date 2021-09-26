class Solution {
    public int sumOfBeauties(int[] nums) {
        //dp
        //keep right most min
        //keep left max
        //loop through and check conditions
        
        int[] rightMostMin = new int[nums.length];
        rightMostMin[nums.length - 1] = nums[nums.length - 1]; //set last element
        
        for(int i = nums.length - 2; i >= 2; i--)
        {
            rightMostMin[i] = Math.min(nums[i], rightMostMin[i + 1]);
        }
        
        int leftMostMax = nums[0], sum = 0;
        
        for(int i = 1; i < nums.length - 1; i++)
        {
            if(nums[i] > leftMostMax && nums[i] < rightMostMin[i + 1])
            {
                sum +=2;
            }
            else if(nums[i] > nums[i - 1] && nums[i] < nums[i + 1])
            {
                sum++;
            }
            
            leftMostMax = Math.max(leftMostMax, nums[i]);
        }
        
        return sum;
    }
}