class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //init char set out of allowed
        //loop through each character in each word
        //if set cotains current char, increment count
        //if count == curr word length, increment consitent
        //return consistent
        
        int consistent = 0;
        Set<Character> set = new HashSet<>();
        
        for(char c : allowed.toCharArray()) set.add(c);

        
        for(String word : words) {
            int count = 0;
            
            for(char c : word.toCharArray()) {
                if(set.contains(c)) count++;
            }
            
            if(count == word.length()) consistent++;
        }
        
        return consistent;
    }
}