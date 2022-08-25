class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //init charMap
        //loop through ransomNote and populate charMap
        //loop through magazine and decrement currChar
        //loop through charMap
        //if any values > 0, that means ransomNote cannot be formed
        //so return false
        //if we pass loop, that means ransomNote can be constructed so return true
        
        int[] charMap = new int[26];
        
        for(char c : ransomNote.toCharArray()) charMap[c - 'a']++;
        
        for(char c : magazine.toCharArray()) charMap[c - 'a']--;
        
        for(int letter : charMap) if(letter > 0) return false;
        
        return true;
    }
}