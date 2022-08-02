class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //init maxHeap
        //loop through matrix
        //add current element to heap
        //if the heap size > k poll off
        //return poll
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                maxHeap.add(matrix[i][j]);
                
                if(maxHeap.size() > k) maxHeap.poll();
            }
        }
        
        return maxHeap.poll();
        
    }
}