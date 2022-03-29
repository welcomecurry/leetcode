class Solution {
    public int findDuplicate(int[] nums) {
        //base case if nums.length == 0 || nums.lenghh == 1
        //return 0;
        //create hashmap
        //populate hashmap with int and occurence of that int
        //loop through map and return key whose value >= 2
        //else return -1 if no duplicates found
        
        if(nums.length == 0 || nums.length == 1)
        {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(value >= 2)
            {
                return key;
            }
        }
        
        return -1;
    }
}