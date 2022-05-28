class Solution {
    public int missingNumber(int[] nums) {
        //init set
        //add all nums to set
        //loop from 0 to nums.length
        //if the set does not contain i, return i
        //if we get through loop there is not missing number so return -1
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums)
        {
            set.add(i);
        }
        
        for(int i = 0; i <= nums.length; i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return -1;
    }
}