class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum
        //create hashmap, count and current sum vars
        //map.put(0,1) since there exists one subarray with sum 0 at the beginning and sum is initialized at 0
        //loop through the array
        //currentSum += currentelement
        //if map contains currentsum - k => increment count with map.get(currSum - k)
        //map.put(currentSum, map.getOrDefault)
        //return count at end
        
        int count = 0, currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            
            if(map.containsKey(currSum - k))
            {
                count += map.get(currSum - k);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}