class Solution {
    public int removeDuplicates(int[] nums) {
        //base check if arr is empty
        //init i pointer that is slow
        //loop through from 0 to length
        //if the nums do not equal each other
            //increment i to move to next position
            //nums[i] = nums[j]
        //return i + 1 since 0 indexed
        
        if(nums.length == 0) return 0;
        
        int i = 0;
        
        for(int j = 1; j < nums.length; j++)
        {
            if(nums[i] != nums[j])
            {
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i + 1;
    }
}