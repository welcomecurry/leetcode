class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //create result list
        //base check if s < p.length or s.length == 0 return empty list
        //loop through string p and create a charmap
        //loop through string s
        //create charmap out of s.substring(i, (p.length() - 1) + i)
        //if the charmaps are equal add i to result 
        //return result
        
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || s.length() < p.length())
        {
            return result;
        }
        
        char[] pCharMap = new char[26];
        
        for(char c : p.toCharArray())
        {
            pCharMap[c -'a']++;
        }
        
        for(int i = 0; i <= s.length() - p.length(); i++)
        {
            String current = s.substring(i, p.length() + i);
            char[] currentSubstringMap = new char[26];
            
            for(char c : current.toCharArray())
            {
                currentSubstringMap[c - 'a']++;
            }
            
            if(Arrays.equals(pCharMap, currentSubstringMap))
            {
                result.add(i);
            }
        }
        
        return result;
    }
}