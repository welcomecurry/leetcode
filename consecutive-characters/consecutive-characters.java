class Solution {
    public int maxPower(String s) {
        //sliding window
        
        int max = 0, left = 0, right = 0;
        
        while(right < s.length())
        {
            int curr = 0;
            
            while(right < s.length() && s.charAt(right) == s.charAt(left))
            {
                right++;
                curr++;
            }
            max = Math.max(max, curr);
            left++;
        }
        
        return max;
    }
}