class Solution {
    public int countPairs(int[] nums, int k) {
        //brute force
        //map all nums to indices
        //loop through each keys value and if the map contains curr / k increment
        
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) 
        {
            map.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            List<Integer> indices = entry.getValue();
            for(int i = 0; i < indices.size(); i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if(indices.get(i) * indices.get(j) % k == 0) count++;
                }
            }
        }
        
        return count;
    }
}