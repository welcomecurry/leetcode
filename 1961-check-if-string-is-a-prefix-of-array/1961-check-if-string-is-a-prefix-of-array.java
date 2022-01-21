class Solution {
    public boolean isPrefixString(String s, String[] words) {
        //loop through while s contains word and append to stringbuilder and return if equal
        
        StringBuilder sb = new StringBuilder();
        
        for(String word : words)
        {
           sb.append(word);
            
           if(s.equals(sb.toString())) return true;
        }
        
        return false;
    }
}