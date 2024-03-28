class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        //sliding window map
        //init map
        //init left and right pointers
        //while j < length
        //incremenet freq of current element to map
        //while right element value is > k decrement left freq and increment left
        //take max of curr length and the distance of the pointers
        //increment j
        
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        
        while(j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            while(map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            
            max = Math.max(max, (j - i) + 1);
            j++;
        }
        
        return max;
    }
}