class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //create temp array and sort the array
        //two pointers left and right
        //loop while from 0 to length, if nums[left] != nums[right] break
        //if start makes it through whole array that means arrays are same so return 0
        //loop while right >= 0, if elements in both arrays do not equal break
        //return right - left + 1, + 1 since zero indexed
        
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        
        while(left < nums.length - 1)
        {
            if(nums[left] != temp[left])
            {
                break;
            }
            left++;
        }
        
        if(left >= nums.length - 1) return 0;
        
        while(right >= 0)
        {
            if(nums[right] != temp[right])
            {
                break;
            }
            right--;
        }
        
        return right - left + 1;
    }
}