class Solution {
    public boolean judgeSquareSum(int c) {
        //rearrange formula to b = sqrt(c - a^2)
        //if we can make b and integer than it is possible so return true
        for(long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            
            if(b == (int) b) return true;
        }
        
        return false;
    }
}