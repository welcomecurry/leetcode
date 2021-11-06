class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        int first = -1, second = -1;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(first == -1 && entry.getValue() == 1) first = entry.getKey();
            else if(first != - 1 && entry.getValue() == 1) second = entry.getKey();
        }
        
        return new int[] {first, second};
    }
}