class Solution {
    public List<Integer> findLonely(int[] nums) {
        //count occruences of nums
        //add nums to set and check if its value is 1 and the set does not contain num - 1 and num + 1
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
            set.add(num);
        }
        
        for(int num : set)
        {
            if(map.get(num) == 1 && !set.contains(num - 1) && !set.contains(num + 1)) 
            {
                output.add(num);
            }
        }
        
        return output;
    }
}