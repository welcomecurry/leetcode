class Solution {
    public String kthDistinct(String[] arr, int k) {
        //count occurences
        //loop again and mark indices and push to minHeap
        //poll off minHeap while k > 0

        Map<String, Integer> map = new HashMap<>();
        
        for(String s : arr) map.put(s, map.getOrDefault(s, 0) + 1);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(map.get(arr[i]) == 1)
            {
                minHeap.add(i);
            }
        }
        
        if(k > minHeap.size()) return "";
        
        while(!minHeap.isEmpty() && k-- > 1)
        {
            minHeap.poll();
        }
        
        return arr[minHeap.poll()];
    }
}