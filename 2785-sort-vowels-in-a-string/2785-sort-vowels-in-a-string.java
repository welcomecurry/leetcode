class Solution {
    public String sortVowels(String s) {
        //convert to char array
        //retreive all vowels and sort char array
        //loop through and everytime we encounter a vowel replace from vowel arr
        //return str
        
        char[] str = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        
        for(char c : str) if(isVowel(c)) vowels.add(c);
        
        Collections.sort(vowels);
        int index = 0;
        
        for(int i = 0; i < str.length; i++) {
            if(isVowel(str[i])) str[i] = vowels.get(index++);
        }
        
        return new String(str);
    }
    
    private boolean isVowel(char c) {
        char lowerCh = Character.toLowerCase(c);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }
}