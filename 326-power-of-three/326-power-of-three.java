class Solution {
    public boolean isPowerOfThree(int n) {
        long pow = 1;
        
        while(pow < n)
        {
            pow *= 3;
        }
        
        return pow == n;
    }
}