class Solution {
    public boolean isPossible(int[] target) {
        //init maxHeap to hold and easily retreive max elements
        //loop through target and add to heap and get total sum
        //loop while maxHeap is not empty
        //poll max element
        //init remainingTotal to sum - max
        //if max element is 1 or remainingTotal is 1 return true
        //if remainingTotal is 0 or reaminingTotal > max return false
        //init newMax the be the max % sum since we can reduce redundant operations instead
        //of subtracting each time
        //if newMax is 0 that means we have case where we only have 1 element in target so ret false
        //set max element to newMax
        //add maxElement back into heap
        //set totalSum to new sum, max element + remainingtotal
        //if we make it through heap loop return true
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        long totalSum = 0;
        
        for(int i : target)
        {
            totalSum += i;
            maxHeap.add(i);
        }
        
        while(!maxHeap.isEmpty())
        {
            int currMax = maxHeap.poll();
            long remainingTotal = totalSum - currMax;
            
            if(currMax == 1 || remainingTotal == 1) return true;
            
            if(remainingTotal == 0 || remainingTotal > currMax) return false;
            
            int newMax = (int) (currMax % remainingTotal); //reduce redundant operations in subtraction
            
            if(newMax == 0) return false;
            
            currMax = newMax;
            maxHeap.add(currMax);
            totalSum = remainingTotal + currMax;
        }
        
        return true;
        

    }
}