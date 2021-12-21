class Solution {
    public boolean isPowerOfTwo(int n) {
        //check if right most bit is set, if no return true
        if(n <= 0) return false;
        
        return (n & (n - 1)) == 0;
    }
}