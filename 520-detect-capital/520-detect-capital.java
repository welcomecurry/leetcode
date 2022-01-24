class Solution {
    public boolean detectCapitalUse(String word) {
        //count upper and lowercase and check conditions
        
        int upper = 0, lower = 0;
        
        for(char c : word.toCharArray())
        {
            if(Character.isUpperCase(c)) upper++;
            else lower++;
        }
        
        return upper == word.length() || 
            lower == word.length() || 
            (Character.isUpperCase(word.charAt(0)) && lower == word.length() - 1);
    }
}