class Solution {
    public boolean increasingTriplet(int[] nums) {
        //dynamic programming
        //base check if length < 3 return false
        //init two arrays, leftMin and rightMax
        //leftMin will hold all mins to left of current element, leftMin[0] = nums[0]
        //rightMax will hold all maxes to right of current element, rightMax[len] = nums[nums.length - 1]
        //loop through array twice to populate leftMin and rightMax arrays
        //loop through nums again, if nums[i] > leftMin[i] and nums[i] < rightMax[i] return true
        //otherwise return false at end since we did not find a valid triplet
        
        if(nums.length < 3) return false;
        
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        
        leftMin[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        
        rightMax[rightMax.length - 1] = nums[nums.length - 1];
        
        for(int i = rightMax.length - 2; i>= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > leftMin[i] && nums[i] < rightMax[i]) return true;
        }
        
        return false;
    }
}