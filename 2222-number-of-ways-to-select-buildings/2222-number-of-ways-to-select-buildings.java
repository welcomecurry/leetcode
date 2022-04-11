class Solution {
    public long numberOfWays(String s) {
        //dynamic programming
        long ones = 0, zeros = 0, onesZeros = 0, zerosOnes = 0, ways = 0;
        
        for(char c : s.toCharArray())
        {
            if(c == '0')
            {
                zeros++;
                onesZeros += ones;
                ways += zerosOnes;
            }
            else
            {
                ones++;
                zerosOnes += zeros;
                ways += onesZeros;
            }
        }
        
        return ways;
    }
}