class Solution {
    public int maxFrequencyElements(int[] nums) {
        //loop through and count freqs and keep track of max
        //loop through and if val == max increment and ret
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, freq = 0;
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                freq += max;
            }
        }
        
        return freq;
    }
}