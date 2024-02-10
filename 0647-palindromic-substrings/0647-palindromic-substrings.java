class Solution {
    public int countSubstrings(String s) {
        //expand around center and count
        //init output
        //convert string to char array
        //loop starting at 0
        //output += isPalindrome(i, i, chars) //center for odd length
        //output += isPalindrome(i, i + 1, chars); //center for even length
        
        int output = 0;
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++)
        {
            output += isPalindrome(i, i, chars); //center for odd length
            output += isPalindrome(i, i + 1, chars); //center for even length
        }
        
        return output;
    }
    
    private int isPalindrome(int start, int end, char[] chars)
    {
        int count = 0;
        
        while(start >= 0 && end < chars.length && chars[start--] == chars[end++])
        {
            count++;
        }
        
        return count;
    }
}