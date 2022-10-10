class Solution {
    public String breakPalindrome(String palindrome) {
        //we just want to break the first half of the string
        //base check if the length <= 1 return empty string
        //loop thorugh string if we encounter a non 'a' char replace it with a and return
        //if the whole string is a's then we will finish the loop and changed the last letter to b
        
        if(palindrome.length() <= 1) return "";
        
        char[] string = palindrome.toCharArray();
        
        for(int i = 0; i < string.length / 2; i++)
        {
            if(string[i] != 'a')
            {
                string[i] = 'a';
                return String.valueOf(string);
            }
        }
        
        string[string.length - 1] = 'b';
        return String.valueOf(string);
    }
}