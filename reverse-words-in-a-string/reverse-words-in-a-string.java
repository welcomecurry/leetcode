class Solution {
    public String reverseWords(String s) {
        String[] string = s.trim().split("\\s+");
        
        int left = 0, right = string.length - 1;
        
        while(left < right)
        {
            String temp = string[left];
            string[left++] = string[right];
            string[right--] = temp;
        }
        
        return String.join(" ", string);
    }
}