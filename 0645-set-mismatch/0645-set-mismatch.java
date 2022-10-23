class Solution {
    public int[] findErrorNums(int[] nums) {
        //init result arr
        //init treemap, key is int and value is occurence
        //count occurences of chars
        //init dup and missingNum = 1
        //loop through nums
        //if map contains key mark if we found duplicate
        //otherwise if its not in the map it must be missing so set it at i
        //return result
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int duplicate = -1, missing = 1;
        
        for(int i = 1; i <= nums.length; i++)
        {
            if(map.containsKey(i))
            {
                if(map.get(i) == 2)
                {
                    duplicate = i;
                }
            }
            else
            {
                missing = i;
            }
        }
        
        return new int[] {duplicate, missing};
    }
}