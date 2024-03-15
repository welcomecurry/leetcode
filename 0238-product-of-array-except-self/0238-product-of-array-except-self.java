class Solution {
    public int[] productExceptSelf(int[] nums) {
        //create 2 arrays left and right which will calcualate the product of all to the right
        //and products all to the left
        //set left[0] to 1 since there is nothing to the left of first element
        //set right[length -1 ] to 1 since there is nothing ot the right of the last element
        //loop through and populate left array starting at 1
        //left[i] = left[i-1] * nums[i - 1]
        //we are taking element before current element and multiplying it with previous prod
        //loop though and populate right array starting at length - 2
        //right[i] = right[i + 1] * nums[i + 1]
        //loop through btoh left and right  
        //set current element to prod of left[i] * right[i]
        //return result
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[right.length - 1] = 1;
        
        for(int i = right.length - 2; i >= 0; i--)
        {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            res[i] = left[i] * right[i];
        }
        
        return res;
    }
}