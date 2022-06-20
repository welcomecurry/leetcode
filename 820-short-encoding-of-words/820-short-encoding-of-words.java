class Solution {
    public int minimumLengthEncoding(String[] words) {
        //sort based on length of string in descending order
        //init stringbuilder
        //loop thorugh every word in words
        //if sb.indexOf(word + "#") == -1, there is no substring that you can make
        //append to stringbuilder and #
        //simply return the length of the encoding
        
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        StringBuilder encoding = new StringBuilder();
        
        for(String word : words)
        {
            if(encoding.indexOf(word + "#") == -1) //there is no substring to encode
            {
                encoding.append(word).append("#");
            }
        }
        
        return encoding.length();
    }
}