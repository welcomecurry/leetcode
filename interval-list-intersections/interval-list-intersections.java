class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //two pointers
        //init output
        //loop while i and j < lengths
        //take the low of the max of first and last
        //take the high as min of first and last
        //if low <= high append to output
        //if second element in first list is < second increment i
        //otherwise increment j
        //return res
        
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        
        while(i < firstList.length && j < secondList.length)
        {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            
            if(low <= high) res.add(new int[] {low, high});
            
            if(firstList[i][1] < secondList[j][1])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}