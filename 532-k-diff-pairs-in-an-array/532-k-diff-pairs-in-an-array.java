class Solution {
    public int findPairs(int[] nums, int k) {
        //create a hashmap
        //map each number to occurence 
        //loop through keyset in map                                                
        //if map contains nums[i] + k && k > 0 || k == 0  map.get(currentNum) > 1 => count++
        //if k > 0 that means we have to subtract elements if k == 0 that means if there are 2 occurences of any
        //number subtracting them will = 0 therfore we reach our k
        //return count
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int x : map.keySet())
        {
            if(map.containsKey(x + k) && k > 0 || k == 0 && map.get(x) > 1)
            {
                count++;
            }
        }
        
        return count;
    }
}