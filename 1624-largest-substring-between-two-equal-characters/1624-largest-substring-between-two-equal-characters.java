class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        //two pointers 
        //while char at i != char at j increment and decrement
        //substring from i to j and return length
        
        if(s.length() == 2 &&  s.charAt(0) == s.charAt(1))
        {
            return 0;   
        }
        
        int i = 0;
        int j = s.length() - 1;
        int maxLength = -1;
        
        while(j != i + 1)
        {

            while(s.charAt(i) != s.charAt(j))
            {
                j--;
            }

            String result = s.substring(i, j);
            maxLength = Math.max(result.length() - 1, maxLength);
                i++;
                j = s.length() - 1;
        }

        
        
        return maxLength;
    }
}