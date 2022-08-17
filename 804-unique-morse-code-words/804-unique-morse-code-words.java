class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //create array of the codes
        //create hashset since we are adding unique codes to the set
        //loop through the words
        //init stringbuilder
        //loop through each char and create a morsecode representation and append code to set
        //return set size
        
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for(String word : words)
        {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray())
            {
                sb.append(codes[c - 'a']);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}