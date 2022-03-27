class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //init output arr of size k
        //init heap array that has soliders at [0] and row at [1]
        //if they values are the same sort in ascending order, otherwise sort by value
        //loop thorugh matrix, and count occurences of 1
        //while heap > k, poll off max elements
        //while k > 0 append output
        //append to output and decrement k
        //return output
        
        int[] output = new int[k];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        for(int i = 0 ; i < mat.length; i++)
        {
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++)
            {
                //case if we have all zeros in a row
                if(mat[i][j] == 1)
                {
                    soldiers++;
                }
                else
                {
                    break;
                }
            }
            maxHeap.add(new int[] {soldiers, i});
        }
                                                                     
        while(maxHeap.size() > k)
        {
            maxHeap.poll();
        }
        
        
        while(k > 0)
        {
            output[--k] = maxHeap.poll()[1]; //poll off row
        }
        
        return output;
    }
}