class Solution {
    public String firstPalindrome(String[] words) {
        //loop through if palidrome return
        //if no palindrome return ""
        
        for(String word : words) {
            if(isPalindrome(word)) return word;
        }
        
        return "";
    }
    
    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        
        while(i < j) {
            if(word.charAt(i++) != word.charAt(j--)) return false;
        }
        
        return true;
    }
}