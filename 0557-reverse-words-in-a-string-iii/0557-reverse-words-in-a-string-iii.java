class Solution {
    public String reverseWords(String s) {
        //split
        //for each word reverse and append to stringbuilder
        
        String[] string = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String word : string)
        {
            sb.append(reverse(word)).append(" ");    
        }
        
        return sb.toString().trim();
    }
    
    private String reverse(String s)
    {
        char[] word = s.toCharArray();
        int left = 0, right = word.length - 1;
        
        while(left < right)
        {
            char temp = word[left];
            word[left++] = word[right];
            word[right--] = temp;
        }
        
        return String.valueOf(word);
    }
}