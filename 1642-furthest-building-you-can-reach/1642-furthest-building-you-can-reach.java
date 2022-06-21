class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //use minHeap to keep track of the height differences
        //loop through heights
        //if the curr building differnce is <= 0 we can just jump, we dont need bricks or ladders
        //otherwise if difference > 0, then we need bricks or ladders so push onto heap
        //if heap size > ladders, then we have used all ladders and now need to use bricks
        //bricks -= poll
        //if bricks <= 0 return i
        //if we make it through loop we can go to last building so return heights.length - 1
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < heights.length - 1; i++)
        {
            int heightDiff = heights[i + 1] - heights[i];
            
            if(heightDiff > 0)
            {
                minHeap.add(heightDiff);
                
                if(minHeap.size() > ladders) //need to use bricks
                {
                    bricks -= minHeap.poll();
                }
                
                if(bricks < 0)
                {
                    return i;
                }
            }
        }
        
        return heights.length - 1;
    }
}