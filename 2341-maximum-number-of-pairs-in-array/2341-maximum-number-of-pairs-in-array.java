class Solution {
    public int[] numberOfPairs(int[] nums) {
        //count occurences
        //add modulo to leftover, remove remainder and add occurence / 2
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        int pairs = 0, leftovers = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int occurs = entry.getValue();
            leftovers += occurs % 2;
            occurs -= occurs % 2;
            pairs += occurs / 2;
        }
        
        return new int[] {pairs, leftovers};
    }
}