class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //similar to twosum
        //init hashmap
        //loop through the time arr
        //take the mod of current element
        //take the complement of current element, if mod is 0 return 0 otherwise return 60 - mod
        //result += map.getOrDefault(complement, 0)
        //insert mod into map
        //return result
        
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : time)
        {
            int mod = t % 60;
            int complement = mod == 0 ? 0 : 60 - mod;
            
            pairs += map.getOrDefault(complement, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        return pairs;
    }
}