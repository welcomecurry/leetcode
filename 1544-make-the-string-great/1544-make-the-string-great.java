class Solution {
    public String makeGood(String s) {
        //base check if length is 1 return s
        //create stringbuilder init with string
        //loop through while i < sb.length - 1
        //if Math.abs(currChar - nextChar) == 32 => that means we found pair
        //delete char at i twice
        //i is the max of i - 1 and 0 since if we have second case we need to reset
        //otherwise increment i
        //return stringbuilder
        
        if(s.length() == 1) return s;
        
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        
        while(i < sb.length() - 1) {
            if(Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) { //found pair
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(i - 1, 0);
            }
            else {
                i++;
            }
        }
            
        return sb.toString();
    }
}