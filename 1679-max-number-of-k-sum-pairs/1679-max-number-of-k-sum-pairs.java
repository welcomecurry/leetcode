class Solution {
    public int maxOperations(int[] nums, int k) {
        //greedy approach since we want to find max
        //sort the array
        //init count
        //init left and right pointers
        //loop through while left < right
        //if nums[left] + nums[right] < k, increment left
        //if nums[left] + nums[right] > k, decrement right
        //if nums[left] + nums[right] are equal, increment count and increment and decrement pointers
        //return count
        
        Arrays.sort(nums);
        
        int count = 0, left = 0, right = nums.length - 1;
        
        while(left < right)
        {
            if(nums[left] + nums[right] < k)
            {
                left++;
            }
            else if(nums[left] + nums[right] > k)
            {
                right--;
            }
            else //they are equal
            {
                count++;
                left++;
                right--;
            }
        }
        
        return count;
        
    }
}