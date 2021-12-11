class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        //binary search
        //get gcd and lcm of a and b
        //magic numbers <= x = x / a + x / b - x / lcm, inclusion exclusion
        //set left to lower bound and upper bound to max
        //binary search till we get smallest x and left will be set on x
        
        long left = 0, right = Long.MAX_VALUE, leastCommonMultiple = lcm(a, b);
        
        while(left < right)
        {
            long mid = left + (right - left) / 2;
            long index = getIndex(mid, a, b, leastCommonMultiple);
            
            if(index >= n)
            {
                right = mid;
            }
            else // index < n
            {
                left = mid + 1;
            }
        }
        
        return (int) (left % 1000000007);
    }
    
    private long getIndex(long num, long a, long b, long c)
    {
        return (num / a) + (num / b) - (num / c); //inclusion exclusion
    }
    
    private long lcm(long a, long b)
    {
        return a * b / gcd(a,b);
    }
    
    private long gcd(long a, long b)
    {
        return a == 0 ? b : gcd(b % a, a);
    }
}