class Solution {
    public boolean halvesAreAlike(String s) {
        //split both strings at halfs and make them lowercase
        //for each string count the vowels
        //return if the vowels are equal
        
        //String firstHalf = s.substring(0, s.length() / 2).toLowerCase();
        //String secondHalf = s.substring(s.length() / 2, s.length()).toLowerCase();

        return countVowels(s.substring(0, s.length() / 2).toLowerCase()) ==                 countVowels(s.substring(s.length() / 2, s.length()).toLowerCase());
    }
    
    private int countVowels(String s)
    {
        int count = 0;
        
        for(char c : s.toCharArray())
        {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                count++;
            }
        }
        
        return count;
    }
}