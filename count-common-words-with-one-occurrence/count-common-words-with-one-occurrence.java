class Solution {
    public int countWords(String[] words1, String[] words2) {
        int count = 0;
        Map<String, Integer> m1 = new HashMap(), m2 = new HashMap<>();
        
        for(String s : words1) m1.put(s, m1.getOrDefault(s, 0) + 1);
        
        for(String s : words2) m2.put(s, m2.getOrDefault(s, 0) + 1);
        
        for(String s : words1) if(m1.containsKey(s) && m2.containsKey(s) && m1.get(s) == 1 && m2.get(s) == 1) count++;
        
        return count;
    }
}