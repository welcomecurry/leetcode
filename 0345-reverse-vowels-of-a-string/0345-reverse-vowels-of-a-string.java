class Solution {
    public String reverseVowels(String s) {
        //convert string into charArray
        //two pointers i and j
        //loop through while i < j
        //if charAt i is not a vowel and charAt j is => increment i
        //if charAt i  is a vowel and charAt j is not => decrement j
        //else swap and increment and decrement both pointers
        //return string.valueOf(charArray)
        
        if(s.length() == 0) return s;
        
        char[] input = s.toCharArray();
        
        int i = 0;
        int j = input.length - 1;
        
        while(i < j)
        {
            if(!isVowel(input[i]) && isVowel(input[j]))
            {
                i++;
            }
            else if(isVowel(input[i]) && !isVowel(input[j]))
            {
                j--;
            }
            else if(isVowel(input[i]) && isVowel(input[j]))
            {
                char temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
            else
            {
                i++;
                j--;
            }
        }
        
        return String.valueOf(input);
    }
    
    private boolean isVowel(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}