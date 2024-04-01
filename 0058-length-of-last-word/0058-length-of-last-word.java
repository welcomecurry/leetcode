class Solution {
    public int lengthOfLastWord(String s) {
        //s.trim to remove any trailing or leading spaces
        //keep length count
        //loop starting from end of string
        //if current char is a space return count
        // else count++
        
        s = s.trim();
        int count = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        
        return count;
    }
}