class Solution {
    public int scoreOfString(String s) {
        //loop through chars and take abs total
        
        char[] string = s.toCharArray();
        int score = 0;
        
        for(int i = 0; i < string.length - 1; i++) {
            score += Math.abs(((int) string[i]) -  ((int) string[i + 1]));  
        }
        
        return score;
    }
}