class Solution {
    public int maxProduct(int[] nums) {
        //loop through and keep track of min and max prod
        
        int max = nums[0], min = nums[0], curr = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            int prevProd = curr;
            
            curr = Math.max(Math.max(curr * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(prevProd * nums[i], min * nums[i]), nums[i]);
            max = Math.max(max, curr);
        }
        
        return max;
    }
}