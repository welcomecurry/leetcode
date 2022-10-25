class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //init two strings for word1 and word2
        //loop through both arrs and create strings out of them
        //return if they are equal
        
        String wordOne = "";
        String wordTwo = "";
        
        for(String s : word1)
        {
            wordOne += s;
        }
        
        for(String s : word2)
        {
            wordTwo += s;
        }
        
        return wordOne.equals(wordTwo);
    }
}