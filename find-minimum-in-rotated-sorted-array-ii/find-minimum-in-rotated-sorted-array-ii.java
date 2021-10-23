class Solution {
    public int findMin(int[] nums) {
        //find pivot point
        //modified binary search
        //base check if nums length == 0
        //two vars left and right
        //while left < right
        //create mid var
        //if nums[mid] == nums[right] decrement right
        //else if nums[mid] > nums[right]
            //left = mid + 1
        //else 
            // right = mid
        //return nums[left] 
        
        int left = 0, right = nums.length - 1;
        
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == nums[right])
            {
                right--;
            }
            else if(nums[mid] > nums[right])
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