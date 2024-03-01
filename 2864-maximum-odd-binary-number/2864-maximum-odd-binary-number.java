class Solution {
    public String maximumOddBinaryNumber(String s) {
        //if just 1 return string with one on end
        //anything greater than 2, fill in left most 1's and ret
        
        int ones = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '1') ones++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(ones == 1) {
            for(int i = 0; i < s.length() - 1; i++) {
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }
        
        for(int i = 0; i < ones - 1; i++) sb.append('1');
        for(int i = 0; i < (s.length() - ones); i++) sb.append('0');
        
        sb.append('1');
        
        return sb.toString();
    }
}