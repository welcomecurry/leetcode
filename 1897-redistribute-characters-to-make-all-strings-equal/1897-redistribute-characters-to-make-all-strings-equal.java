class Solution {
    public boolean makeEqual(String[] words) {
        //count chars
        //check whether frequency of the char can be divided equally into all the strings given
        
        Map<Character, Integer> map = new HashMap<>();
        int n = words.length;
        
        for(String word : words) {
            for(char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % n != 0) {
                return false;
            } 
        }
        
        return true;
    }
}