class Solution {
    public int minStartValue(int[] nums) {
        //find the minimum sum and return 1 - minSum
        
        int sum = 0, minSum = 0;
        
        for(int i : nums)
        {
            sum += i;
            minSum = Math.min(minSum, sum);
        }
        
        return 1 - minSum;
    }
}