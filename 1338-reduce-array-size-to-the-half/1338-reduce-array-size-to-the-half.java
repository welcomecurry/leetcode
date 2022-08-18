class Solution {
    public int minSetSize(int[] arr) {
        //count occurences of nums in treemap in descending order
        //init count and size
        //loop while size > arr.length / 2
        //increment count and decrement size based on occurence
        //if size <= arr.length / 2 return size
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            maxHeap.add(new int[] {entry.getKey(), entry.getValue()});
        }
        
        int count = 0, size = arr.length;
        
        while(size > arr.length / 2)
        {
            size -= maxHeap.poll()[1];
            count++;
        }
        
        return count;
        
    }
}