class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        //Sort by the left bound, and when left bounds are equal, sort right bounds by reverse order; Therefore, no interval can cover previous ones;
        //Loop through the intervals, whenever current right most bound < next interval's right bound, it means current interval can NOT cover next interval, update right most bound and increase counter by 1.
        
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        
        int max = 0, count = 0;
        
        for(int[] interval : intervals)
        {
            if(interval[1] > max)
            {
                max = interval[1];
                count++;
            }
        }
        
        return count;
    }
}