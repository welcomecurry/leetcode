class Solution {
    public int numOfPairs(String[] nums, String target) {
        int pairs = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums.length; j++)
            {
                if(i == j) continue;
                
                if(nums[i].length() + nums[j].length() == target.length())
                {
                    pairs += target.equals(nums[i] + nums[j]) ? 1 : 0;
                }
            }
        }
        
        return pairs;
    }
}