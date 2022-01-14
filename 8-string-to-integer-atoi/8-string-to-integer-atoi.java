class Solution {
    public int myAtoi(String s) {
        //base check for empty string
        //init result, index, sign
        //remove white space
        //check for negative sign
        //loop through string while in bounds and characters are digits
        //check for 5th condition
        //otherwise append to result
        //return result
        
        if(s.length() == 0) return 0;
        
        int result = 0, i = 0, sign = 1;
        
        while(i < s.length() && s.charAt(i) == ' ') i++; //remove leading spaces
        
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) //sign check
        {
            sign = s.charAt(i) == '-' ? -1 : 1; 
            i++; 
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
        {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
			}
            
            result = (result * 10) + (s.charAt(i++) - '0'); //append digit
        }
        
        return result * sign;
    }
}