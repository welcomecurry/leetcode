class Solution {
    public int longestPalindrome(String s) {
        //create charmap of size 128 since we are count capitals
        //loop through string and increment occurences
        //if length is 2 add to length and reset count
        //if length == s.length return length otherwise return length + 1
        //plus 1 since a palindrome will have 1 letter that doesnt appear twice
        
        int length = 0;
        int[] charMap = new int[126];
        
        for(char c : s.toCharArray())
        {
            if(++charMap[c] == 2)
            {
                length += 2;
                charMap[c] = 0;
            }
        }
        
        return length == s.length() ? length : length + 1;
    }
}