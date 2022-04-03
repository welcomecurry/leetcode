class Solution {
    public void nextPermutation(int[] nums) {
        //loop through starting from end of the array
        //we need to find the point where nums[i] starts increasing from a decreasing sequence
        //if i >= 0, we need to loop through from the end and find a num greater than nums[i]
        //then we swap nums[i] and nums[j]
        //then we reverse from i to length
        
        int inversePoint = nums.length - 2;
        
        while(inversePoint >= 0 && nums[inversePoint] >= nums[inversePoint + 1])
        {
            inversePoint--;
        }
        
        if(inversePoint >= 0)
        {
            int swapPoint = nums.length - 1;
            
            while(swapPoint >= 0 && nums[swapPoint] <= nums[inversePoint])
            {
                swapPoint--;
            }
            
            swap(nums, inversePoint, swapPoint);
        }
        
        reverse(nums, inversePoint + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int start, int end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
            
        }
    }
}