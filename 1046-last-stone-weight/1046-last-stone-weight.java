class Solution {
    public int lastStoneWeight(int[] stones) {
        //init maxHeap
        //add all elements into heap
        //loop while heap size > 1
        //poll of two largest elements
        //if they are equal continue
        //otherwise subtract largest from secondlargest and add to heap
        //if heap is not empty return maxHeap.poll() otherwise 0
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i : stones)
        {
            maxHeap.add(i);
        }
        
        while(maxHeap.size() > 1)
        {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            
            if(largest == secondLargest)
            {
                continue;
            }
            else
            {
                maxHeap.add(largest - secondLargest);
            }
        }
        
        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }
}