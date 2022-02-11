class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        //prefix sum
        //loop thorugh to n + 1
        //calc nums of 0 in nums left and calc nums of 1 in nums right
        //score the addition of both
        //if curr > max clear result and set max to curr
        //if curr == max append indice to result
        
        List<Integer> result = new ArrayList<>();
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        
        for(int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
        
        int maxScore = -1;
        
        for(int i = 0; i < prefix.length; i++)
        {
            int zerosInLeft = i - prefix[i];
            int onesInRight = prefix[prefix.length - 1] - prefix[i];
            int currScore = zerosInLeft + onesInRight;
            
            if(currScore > maxScore)
            {
                result.clear();
                maxScore = currScore;
            }
            
            if(currScore == maxScore) result.add(i);
        }
        
        return result;
    }
}