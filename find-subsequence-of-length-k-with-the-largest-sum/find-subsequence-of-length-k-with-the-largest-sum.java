class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //init minHeap and sort by number
        //loop through nums and add to minHeap if the size is > k poll off elements
        //once we have the top k elements sort by index so we can keep the order of elements
        //then output
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        for(int i = 0; i < nums.length; i++)
        {
            minHeap.add(new int[] { nums[i], i } );
            
            if(minHeap.size() > k) minHeap.poll();
        }
        
        int[] maxSub = new int[k];
        List<int[]> maxNums = new ArrayList<>(minHeap);
        Collections.sort(maxNums, (a,b) -> a[1] - b[1]);
        
        for(int i = 0; i < maxSub.length; i++)
        {
            maxSub[i] = maxNums.get(i)[0];
        }
        
        return maxSub;
    }
}