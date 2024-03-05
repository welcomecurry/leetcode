class Solution {
    public int minimumLength(String s) {
        //2 pointer
        //left at 0 and right at length
        //loop while left < right and left and right chars equal eachother
        //get current letter
        //while left <= right and left == current letter, increment
        //while right >= left and right == curr, decrement
        //return difference of pointers
        
        int left = 0, right = s.length() - 1;
        
        while(left < right && s.charAt(left) == s.charAt(right)) {
            char curr = s.charAt(left);
            
            while(left <= right && s.charAt(left) == curr) {
                left++;
            }
            
            while(right >= left && s.charAt(right) == curr) {
                right--;
            }
        }
        
        return (right - left) + 1;
    }
}