class Solution {
    public int[] searchRange(int[] nums, int target) {
        //modified binary search
        
        int firstPos = binarySearch(nums, 0, nums.length - 1, target, true);
        int lastPos = binarySearch(nums, 0, nums.length - 1, target, false);
        
        return new int[] {firstPos, lastPos};
    }
    
    private int binarySearch(int[] nums, int low, int high, int target, boolean searchFirst)
    {
        //init result
        //loop while low <= high
        //init mid
        //if nums[mid] == target
        //set result to mid
        //if we are searching for the first position, shrink right side
        //if we are searching for last position, shrink left side
        //now normal binary search conditions
        //otherwise if nums[mid] > target, shrink right side
        //otherwise nums[mid] < target, shrink right side
        
        int result = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target)
            {
                result = mid;
                
                if(searchFirst)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return result;
    }
}