class Solution {
    public String orderlyQueue(String s, int k) {
       //if k == 1 then rotate till we find answer
        //otherwise just sort the string and return it
        
        if(k == 1)
        {
            String answer = s;
            
            for(int i = 0; i < s.length(); i++)
            {
                String rotatedOneChar = s.substring(i) + s.substring(0, i);
                
                if(rotatedOneChar.compareTo(answer) < 0)
                {
                    answer = rotatedOneChar;
                }
            }
            
            return answer;
        }
        else
        {
            char[] string = s.toCharArray();
            Arrays.sort(string);
            return new String(string);
        }
    }
}