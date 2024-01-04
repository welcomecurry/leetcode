class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if(val == 1) {
                return -1;
            }
            
            count += (val / 3);
            
            if(val % 3 != 0) count++;
        }
        
        return count;
    }
}