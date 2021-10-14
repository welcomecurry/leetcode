class Solution {
    public String minRemoveToMakeValid(String s) {
        //init bracketCount
        //convert to charArray
        //loop through left to right
        //if the current char is a '(' increment count
        //otherwise if char is ')', if the count > 0 that means we have a corressponding opening bracket
        //if the count <= 0 that means we don't have a corresponding closing bracket so we need to remove it so set to 0
        //reset count
        //loop through from right to left and repeat this time looking for closing brackets
        //finally init stringbuilder and build string and return
        
        int bracketCount = 0;
        char[] string = s.toCharArray();
        
        for(int i = 0; i < string.length; i++)
        {
            if(string[i] == '(')
            {
                bracketCount++;
            }
            else if(string[i] == ')')
            {
                if(bracketCount > 0)
                {
                    bracketCount--;
                }
                else
                {
                    string[i] = 0;
                }
            }
        }
        
        bracketCount = 0;
        
        for(int i = string.length - 1; i >= 0; i--)
        {
            if(string[i] == ')')
            {
                bracketCount++;
            }
            else if(string[i] == '(')
            {
                if(bracketCount > 0)
                {
                    bracketCount--;
                }
                else
                {
                    string[i] = 0;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : string)
        {
            if(c != 0) sb.append(c);
        }
        
        return sb.toString();
    }
}