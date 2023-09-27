class Solution {
    public String decodeAtIndex(String S, int K) {
        //init size to a long since K can be 10^9
        //loop through the string to determine size
            //if character is a digit size *= digit
            //otherwise increment size
        //loop through string again starting from end
            //k = k % size, we are reducing the string each iteration till we find the desired index
            //if k == 0 || k == size and the current character is a letter
                //return that char
        //otherwise if current char is a digit, size /= char
        //otherwise decrement size
        //if we get through loop, that means no char at specified index so return null
        
        long size = 0;
        
        for(char c : S.toCharArray())
        {
            if(Character.isDigit(c))
            {
                size *= (c - '0');
            }
            else
            {
                size++;
            }
        }
        
        for(int i = S.length() - 1; i >= 0; i--)
        {
            char c = S.charAt(i);
            K %= size;
            
            if((K == 0 || K == size) && Character.isLetter(c))
            {
                return Character.toString(c);    
            }
            
            if(Character.isDigit(c))
            {
                size /= (c - '0');
            }
            else
            {
                size--;
            }
        }
        
        return null;
    }
}