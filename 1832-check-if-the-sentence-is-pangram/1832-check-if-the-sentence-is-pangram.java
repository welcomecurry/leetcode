class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] charMap = new int[26];        
        for(char c : sentence.toCharArray())
        {
            charMap[c - 'a']++;
        }
        
        for(int i : charMap)
        {
            if(i < 1)
            {
                return false;
            }
        }
        return true;
    }
}