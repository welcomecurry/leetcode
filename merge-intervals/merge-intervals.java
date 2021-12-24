class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by starting 
        //create output array
        //set current interval to first element
        //loop through intervals
        //create vars for starting and ending indices for currentinterval and newinterval
        //if end of current interval >= beginning of new interval 
            //=> we found overlap so update end index of current interval to max of ends 
        //otherwise we did not find an overlap so set currentInterval to new interval and add to output
        //return output
        
        if(intervals.length == 1) return intervals;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList<>();
        int[] currentInterval = intervals[0];
        output.add(currentInterval);
        
        for(int[] interval : intervals)
        {
            int currentIntervalStart = currentInterval[0];
            int currentIntervalEnd = currentInterval[1];
            int newIntervalStart = interval[0];
            int newIntervalEnd = interval[1];
            
            if(currentIntervalEnd >= newIntervalStart)
            {
                currentInterval[1] = Math.max(currentIntervalEnd, newIntervalEnd);
            }
            else
            {
                currentInterval = interval;
                output.add(currentInterval);
            }
            
        }
        
        return output.toArray(new int[output.size()][]);
    }
}