class Solution {
    public double average(int[] salary) {
        //minheap, poll off first and loop till size - 1
        double avg = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int sal : salary) minHeap.add(sal);
        
        minHeap.poll(); //remove min
        
        int end = minHeap.size();
        int size = end;
        
        while(size-- > 1) avg += minHeap.poll();
        
        return avg / (end - 1);
    }
}