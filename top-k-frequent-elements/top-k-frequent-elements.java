class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            maxHeap.add(new int[] { entry.getKey(), entry.getValue() });
        }
        
        int[] output = new int[k];
        int index = 0;
        
        while(!maxHeap.isEmpty() && k-- > 0)
        {
            output[index++] = maxHeap.poll()[0];
        }
        
        return output;
    }
}