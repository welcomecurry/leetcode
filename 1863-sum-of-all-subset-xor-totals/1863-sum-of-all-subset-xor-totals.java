class Solution {
    int totalSum = 0;
    public int subsetXORSum(int[] nums) {
        dfs(0, totalSum, nums);
        return totalSum;
    }
    
    private void dfs(int index, int prevSum, int[] nums) {
        if(index >= nums.length) return;
        
        for(int i = index; i < nums.length; i++) {
            int currSum = prevSum ^ nums[i];
            totalSum += currSum;
            dfs(i + 1, currSum, nums);
        }
    }
}