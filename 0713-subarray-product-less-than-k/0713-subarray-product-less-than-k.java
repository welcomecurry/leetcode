class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //base case if k <= 1 return 0;
        //variables for product, count
        //sliding window so left and right
        //while right < nums.length
        //prod *= nums[right]
        //while(prod >= k) prod /= nums[left] left++
        //count += right - left + 1
        //right++
        //return count
        
        if(k <= 1) return 0;
        
        int product = 1, count = 0, left = 0, right = 0;
        
        while(right < nums.length) {
            product *= nums[right];
            
            while(product >= k) {
                product /= nums[left++];
            }
            
            count += right - left + 1; //number of arrays
            
            right++;
        }
        
        return count;
    }
}