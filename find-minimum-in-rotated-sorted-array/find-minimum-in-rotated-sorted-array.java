class Solution {
    public int findMin(int[] nums) {
        //find pivot
        
        int pivot = -1, left = 0, right = nums.length - 1;
        
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        
        return nums[left];
    }
}