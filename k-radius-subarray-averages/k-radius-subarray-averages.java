class Solution {
    public int[] getAverages(int[] nums, int k) {
        //prefix sum
        //init output
        //loop through nums starting at k
        //The sum of window ith is prefix[i+k+1] - prefix[i-k]
        //we are using long because of integer overflow
        
        long[] prefix = new long[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++)
        {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        int[] output = new int[nums.length];
        Arrays.fill(output, - 1);
        int radius = (k * 2) + 1;
        
        for(int i = k; i < nums.length - k; i++)
        {
            output[i] = (int) ((prefix[i + k + 1] - prefix[i - k]) / radius);
        }
        
        return output;
    }
}