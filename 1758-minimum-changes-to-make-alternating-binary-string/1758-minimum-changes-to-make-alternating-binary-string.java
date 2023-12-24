class Solution {
    public int minOperations(String s) {
        //return min of flips if string starts with 0 or 1
        return Math.min(numOfFlips(s, '0'), numOfFlips(s, '1'));
    }
    
    private int numOfFlips(String s, char expected)
    {
        int flipCount = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != expected)
            {
                flipCount++;
            }
            //flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }
    
    private char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }
}