class Solution {
    public int prefixCount(String[] words, String pref) {
        //loop through words and take the substring of length pref and check if it wquals
        
        int count = 0;
        
        for(String word : words)
        {
            if(word.length() >= pref.length() && pref.equals(word.substring(0, pref.length())))                 {
                count++;
            }
        }
        
        return count;
    }
}