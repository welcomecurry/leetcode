class Solution {
    public int fillCups(int[] amount) {
        //max heap
        //while size > 1, poll off first 2, sub 1, if > 0 insert back and += 2 seconds
        //return seconds + poll
        
        int seconds = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i : amount) maxHeap.add(i);
        
        
        while(maxHeap.peek() != 0) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            
            first--;
            second--;
            
            if(first > 0) {
                maxHeap.add(first);
            } else {
                maxHeap.add(0);
            }
            
            if(second > 0) {
                maxHeap.add(second);
            } else {
                maxHeap.add(0);
            }
            
            seconds++;
        }
        
        return seconds;
    }
}