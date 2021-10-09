class Solution {
    public String longestPalindrome(String s) {
        //using same technique in palindromic substrings problem, expand around center and count
        //init start and ends to keep track of
        //loop starting at 0
        //get palindrome from i to i for odd length
        //get palindrome from i to i + 1 for even length
        //set maxString to max palindrome string
        //return max
        
        String longest = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            String odd = palindrome(i, i, s);
            String even = palindrome(i, i + 1, s);
            
            if(odd.length() > longest.length())
            {
                longest = odd;
            }
            
            if(even.length() > longest.length())
            {
                longest = even;
            }
        }
        
        return longest;
    }
    
    private String palindrome(int start, int end, String s)
    {
        
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }
        
        return s.substring(start + 1, end);
    }
}