class Solution {
    public int findMaxLength(int[] nums) {
        //we want to find the longest contigious subarray whose sum is 0
        //loop through nums and set all 0's to -1
        //loop through nums again and keep a running sum and map to store sums
        //if the map contains the sum, take max of current index - sum
        
        for(int i = 0; i < nums.length; i++) if(nums[i] == 0) nums[i] = -1;
        
        int runningSum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++)
        {
            runningSum += nums[i];
            
            if(map.containsKey(runningSum))
            {
                max = Math.max(max, i - map.get(runningSum));
            }
            else
            {
                map.put(runningSum, i);
            }
        }

        return max;
    }
}