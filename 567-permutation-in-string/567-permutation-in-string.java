class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //create charmap out of s1
        //loop through s2 while i <= s2.length - s1.length
        //take substring from i to s2.length + i
        //create temp charmap out of substring
        //if temp map and charmap equal return true
        //if we get through loop there is no permutation in string so return false
        
        char[] string1 = new char[26];
        for(char c : s1.toCharArray())
        {
            string1[c - 'a']++;
        }
        
        for(int i = 0; i <= s2.length() - s1.length(); i++)
        {
            String currSubstring = s2.substring(i, s1.length() + i);
            char[] temp = new char[26];
            
            for(char c : currSubstring.toCharArray())
            {
                temp[c - 'a']++;
            }
            
            if(Arrays.equals(string1, temp)) return true;
        }
        
        return false;
    }
}