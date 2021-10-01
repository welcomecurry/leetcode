class Solution {
    public int search(int[] nums, int target) {
        //binary search since it is sorted
        //we need to find the pivot
        //while left < right
        //get midpoint
        //if nums[midpoint] > nums[right] left = mid + 1
        //else right = mid
        //create new var start equal to left since left is at pivot
        //reset left and right
        //now we need to check what side to search
        //if target >= nums[start] && target <= nums[right]
        //set left to start
        //else set right to start
        //do normal binary search with left and right
        //if we get through loop with no match return -1
        
        int left = 0, right = nums.length - 1;
        
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
        
        int pivot = left;
        left = 0;
        right = nums.length - 1;
        
        if(target >= nums[pivot] && target <= nums[right])
        {
            left = pivot;
        }
        else
        {
            right = pivot;
        }
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target)
            {
                return mid;
            }
            
            if(nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}