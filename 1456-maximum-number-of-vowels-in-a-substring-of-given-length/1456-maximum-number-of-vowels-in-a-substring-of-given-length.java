class Solution {
    public int maxVowels(String s, int k) {
        //sliding window
        //init vowel set for constant lookup
        //init max and currentCount
        //loop through string
        //if set contains char at i, increment currCount
        //if we are past k and char At j-k is vowel decrment currCount
        //take max on each iteration
        //return max
        
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int max = 0, currCount = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(vowelSet.contains(s.charAt(i)))
            {
                currCount++; //add right pointer char
            }
            
            if(i >= k && vowelSet.contains(s.charAt(i - k)))
            {
                currCount--; //remove left pointer char
            }
            
            max = Math.max(max, currCount);
        }
        
        return max;
    }
}