class Solution {
    public String minWindow(String s, String t) {
        //base case if s is empty return ""
        //init charMap of 128 since we are including capitals
        //loop through t and populate charMap
        //init count for character count, left and right pointers, minLength
        //startIndex and endIndex init to -1, if by end either is negative return ""
        //loop through while right < s.length
        //if current char is > 0, (is in t), increment chararcterCount
        //decrement current char
        //if we have a valid substring, count == t.length()
        //decrease window, if left < right and charAt left < 0 
        //in order to minimize the string if we have redundant characters at lo 
        //we decremented non valid chars to mark them and move left window pointer
        //if we found a new min substring, right - left + 1, +1 since zero indexed
        //set startIndex to left and end to right + 1 since zero indexed
        //since we are on a valid substring we need to move the window
        //increment the character we decremented earlier at left and pointer and
        //decrement count, since we no longer have a valid substring at this point
        //at end of loop, if are indexes never changed return empty otherwise substr
        
        if(s.length() == 0) return "";
        
        int[] charMap = new int[128];
        
        for(char c : t.toCharArray())
        {
            charMap[c]++;
        }
        
        int count = 0, lo = 0, hi = 0, minLength = Integer.MAX_VALUE;
        int startIndex = -1, endIndex = -1;
        
        for(hi = 0; hi < s.length(); hi++)
        {
            //if we find character in t string increment character count
            if(charMap[s.charAt(hi)] > 0)
            {
                count++;
            }
            //decrement current character, remember valid chars are init to 1
            charMap[s.charAt(hi)]--;
            
            //if we have a valid substring
            if(count == t.length())
            {
                //remove redundant chars at lo pointer
                while(lo < hi && charMap[s.charAt(lo)] < 0)
                {
                    //remove curr occurence from charMap and progress pointer
                    charMap[s.charAt(lo)]++;
                    lo++;
                }
                
                //if we found a new min substring, if new currSubLength < currMinLen
                if(hi - lo + 1 < minLength)
                {
                    minLength = hi - lo + 1;
                    startIndex = lo;
                    endIndex = hi + 1;
                }
                
                //move window since we just computed a valid substring
                //remove curr occurence from charMap and progress pointer
                //decrement count, since we no longer have a valid substring
                charMap[s.charAt(lo)]++;
                lo++;
                count--;
            }
        }
        
        return startIndex == -1 ? "" : s.substring(startIndex, endIndex);
    }
}