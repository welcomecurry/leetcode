class Solution {
    public String decodeString(String s) {
        //two stacks => count stack and string stack
        //init a result string and an index
        //loop through while i < length
        //if char is a digit keep looping through while it is a digit, when done push onto count stack
        //if char is [ push result string onto string stack and reset string
        //if char is ] loop through from 0 to count and append res to stringbuilder, res = sb
        //otherwise if is a letter append to res
        
        Stack<Integer> count = new Stack<>();
        Stack<String> strings = new Stack<>();
        
        String result = "";
        int i = 0;
        
        while(i < s.length())
        {
            if(Character.isDigit(s.charAt(i)))
            {
                int currCount = 0;
                while(Character.isDigit(s.charAt(i)))
                {
                    currCount = currCount * 10 + (s.charAt(i) - '0');
                    i++;
                }
                count.push(currCount);
            }
            else if(s.charAt(i) == '[')
            {
                strings.push(result);
                result = "";
                i++;
            }
            else if(s.charAt(i) == ']')
            {
                StringBuilder temp = new StringBuilder(strings.pop());
                int currCount = count.pop();
                for(int j = 0; j < currCount; j++)
                {
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            }
            else //if current char is a letter
            {
                result += s.charAt(i);
                i++;
            }
        }
        
        return result;
    }
}