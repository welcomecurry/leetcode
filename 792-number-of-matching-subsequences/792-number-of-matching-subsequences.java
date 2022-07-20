class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        for(String word : words)
        {
            if(isSubsequence(s, word))
            {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isSubsequence(String initialString, String currWord)
    {
        int prevCharIndex = 0;
        
        for(char c : currWord.toCharArray())
        {
            int currIndex = initialString.indexOf(c, prevCharIndex); //start looking for c start at prev
            
            if(currIndex == -1) return false; //did not find char
            
            prevCharIndex = currIndex + 1;
        }
        
        return true;
    }
}