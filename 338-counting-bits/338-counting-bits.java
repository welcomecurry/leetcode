class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        
        for(int i = 0; i <= n; i++)
        {
            output[i] = count(i);
        }
        
        return output;
    }
    
    private int count(int n)
    {
        int ones = 0;
        
        while(n != 0)
        {
            ones += (n & 1);
            n >>>= 1;
        }
        
        return ones;
    }
}