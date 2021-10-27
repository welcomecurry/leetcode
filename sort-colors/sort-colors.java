class Solution {
    public void sortColors(int[] nums) {
        //bsae case if nums.length == 1 return
        //create 3 variables start, end and index
        // while start < end && index < end
        //if nums[index] == 0 swap nums[index] to nums[start] and make nums index 0 and start++ and index++
        // if nums[index] == 2 swap nums[end] to nums[index] make nums end 2 and end-- no index++ since we dont know what value we are swapping.
        
        if(nums.length == 1) return;
        
        int left = 0, right = nums.length - 1, index = 0;
        
        while(left < right && index <= right)
        {
            if(nums[index] == 0)
            {
                nums[index++] = nums[left];
                nums[left++] = 0;
            }
            else if(nums[index] == 2)
            {
                nums[index] = nums[right];
                nums[right--] = 2;
            }
            else
            {
                index++;
            }
        }
    }
}