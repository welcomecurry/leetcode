class Solution {
    public int trap(int[] height) {
        //dynamic programming
        //base check if height.length == 0 || is null return 0
        //we need to create 2 arrays which hold the max height to left of current position
        //and max height to the right of the position
        //first we set LL[0] to height[0] since we need to compare [i- 1] to current
        //LL[i] = max of current element and LL[i-1] and populate for all heights
        //then we need to find the maxes to the right of the current element
        //so we will start looping from the end
        //again, set RR[height - 1] = height[height.length - 1] since we starting from end
        //then do the same steps as the left
        //then we want to loop through 3 arrays simultaneously 
        //sum += the min of LL[i] and RR[i] - the current element
        //return sum
        
        if(height.length == 0 || height == null) return 0;
        
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int sum = 0;
        
        maxLeft[0] = height[0];
        
        for(int i = 1; i < height.length; i++)
        {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        
        maxRight[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--)
        {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        
        for(int i = 0; i < height.length - 1; i++)
        {
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return sum;
    }
}