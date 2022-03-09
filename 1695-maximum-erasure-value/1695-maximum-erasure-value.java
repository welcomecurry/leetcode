class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //sliding window
        //init set, sum and max
        //loop while j < nums.length
        //if the set contains the current number, 
        //remove it increment i, and remove ith element
        //otherwise add to set increment j and add sum
        //take max sum
        
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        
        while(j < nums.length)
        {
            if(set.contains(nums[j]))
            {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            else
            {
                set.add(nums[j]);
                sum += nums[j];
                j++;
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
}