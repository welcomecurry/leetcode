class Solution {
    public int minimumDeletions(int[] nums) {
        //mark min and max indices
        //find distance from front, back and both sides
        //return the min of distances
        
        if(nums.length == 1) return 1;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
                maxIndex = i;
            }
            
            if(nums[i] < min)
            {
                min = nums[i];
                minIndex = i;
            }
        }
        
        int distanceFromFront = Math.max(minIndex, maxIndex) + 1;
        int distanceFromBack = nums.length - Math.min(minIndex, maxIndex);
        int distanceFromBothSides = Math.min(minIndex, maxIndex) + nums.length - Math.max(minIndex, maxIndex) + 1;
        
        return Math.min(distanceFromFront, Math.min(distanceFromBack, distanceFromBothSides));
    }
}