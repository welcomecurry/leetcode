class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort intervals according to start value.
        //if the start of a interval is less than the end of the previous interval, then increment count and also update the current min to the Min(interval[i][0],currMin). Larger interval might be overlapping with some other interval , so we remove the larger interval.
        //otherwise, just update curMin to current intervals end.
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int output = 0, curr = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] < curr)
            {
                curr = Math.min(intervals[i][1], curr);
                output++;
            }
            else
            {
                curr = intervals[i][1];
            }
        }
        
        return output;
    }
}