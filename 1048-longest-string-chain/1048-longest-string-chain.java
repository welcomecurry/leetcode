class Solution {
    public int longestStrChain(String[] words) {
        //init hashmap to map occurence of strings
        //sort words by length
        //loop through each word
        //for each substring in the current word
        //if map contains current string, increment occurence if in map
        //take max of output and max
        //put current word with max
        
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        int longest = 0;
        
        for(String word : words)
        {
            int max = 0;
            for(int i = 0; i < word.length(); i++)
            {
                String curr = word.substring(0, i) + word.substring(i + 1);
                
                max = Math.max(max, map.getOrDefault(curr, 0) + 1);
            }
            
            longest = Math.max(longest, max);
            map.put(word, max);
        }
        
        return longest;
    }
}