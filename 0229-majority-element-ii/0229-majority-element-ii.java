class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //create hashmap and arraylist
        //loop through the array and map each element
        //loop through the map if the value >= n / 3 add to list
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(value > n / 3) majorityElements.add(key);
        }
        
        return majorityElements;
    }
}