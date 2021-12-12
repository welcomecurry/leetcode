class Solution {
    public boolean areOccurrencesEqual(String s) {
        //count occurences
        //loop through and occurences dont match
        //if we make it through occurence check return true
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        int occur = map.get(s.charAt(0));
        for(Map.Entry<Character, Integer> entry : map.entrySet()) 
        {
            if(occur != entry.getValue()) return false;    
        }
        
        return true;
    }
}