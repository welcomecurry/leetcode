class Solution {
    public boolean validPalindrome(String s) {
        //two pointers a and b a = 0 b = s.length
        //loop through string
        //if charAt a != char at b call helper function that checks if string is palindrome
        //from a+1 to b and a to b-1 check different substring where there isnt exception
        // if one is true return true
        // else if we get through true
        
        int aPointer = 0;
        int bPointer = s.length() - 1;
        
        while(aPointer <= bPointer)
        {
            if(s.charAt(aPointer) != s.charAt(bPointer))
            {
                return isPalindrome(s, aPointer + 1, bPointer) || isPalindrome(s, aPointer,                   bPointer - 1);
            }
            aPointer++;
            bPointer--;
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int low, int high)
    {
        int aPointer = low;
        int bPointer = high;
        
        while(aPointer <= bPointer)
        {
            if(s.charAt(aPointer) != s.charAt(bPointer))
            {
                return false;
            }
            aPointer++;
            bPointer--;
        }
        
        return true;
    }
}