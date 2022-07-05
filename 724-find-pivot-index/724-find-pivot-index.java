class Solution {
    public int pivotIndex(int[] nums) {
        //loop through take sum
        //loop through again, and decrement sum and increment left sum
        //if sum == return i
        
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            
            if(rightSum == leftSum) return i;
            
            leftSum += nums[i];
        }
        
        return -1;
    }
}