class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //init dp array and set all elements to false
        //set first element to true, (base case) since we can from an empty string ""
        //example: "",a,b,c,d,e,f
        //we esentially are getting to a character and looping backwards to form a string
        //if that string is in the wordDict set current element to true
        //if we get to the last element and its true then it satisfys and
        //can be segmented into a space-separated sequence
        //loop through starting at 1
        //loop through at i - 1
        //if the j element is true and currsubstring is in wordDict, set currElement to true
        //return if the last element is true
        
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                if(dp[j] && wordDict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}