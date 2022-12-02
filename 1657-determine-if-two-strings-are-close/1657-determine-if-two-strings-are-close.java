class Solution {
    public boolean closeStrings(String word1, String word2) {
        //base check if word1 and word2 are equal
        //init two charFreq arrays
        //take frequencies of both strings
        //first check
        //loop through from 0 to 26
        //if either string does not contain the letter we can return false;
        //second check
        //sort both arrays so the frequencies of all the characters are the same
        //return if they are equal, if equal => it has passed all checks and is a "close" string
        
        if(word1.length() != word2.length()) return false;
        
        int[] w1 = new int[26], w2 = new int[26];
        
        for(int i = 0; i < word1.length(); i++)
        {
            w1[word1.charAt(i) - 'a']++;
            w2[word2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if((w1[i] == 0 && w2[i] != 0) || (w2[i] == 0 && w2[i] != 0))
            {
                return false;
            }
        }
        
        Arrays.sort(w1);
        Arrays.sort(w2);
        
        return Arrays.equals(w1, w2);
        
    }
}