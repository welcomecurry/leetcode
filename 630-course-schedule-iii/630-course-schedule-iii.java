class Solution {
    public int scheduleCourse(int[][] courses) {
        //sort by lastdays, if lastdays are the same sort duration in ascending order
        //init maxHeap to store courses
        //init time
        //loop through courses
        //check if duration of current course  <= lastday, is valid course
        //check if duration of current course + time <= lastday
            //if yes push duration onto heap and add to total time
        //otherwise if we are over the time, check if we can replace we next largest element
        //if heaps peek > current duration, poll off, decrement time and add current duration
        //return heap size
        
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        
        for(int[] course : courses)
        {
            if(course[0] <= course[1]) //valid course, duration is not longer than last day
            {
                if(course[0] + time <= course[1]) //can take course
                {
                    maxHeap.add(course[0]);
                    time += course[0];
                }
                else //totalTime goes over lastday, check if we can swap a class
                {
                    if(maxHeap.peek() > course[0]) //we can add a shorter course
                    {
                        time -= maxHeap.poll();
                        maxHeap.add(course[0]);
                        time += course[0];
                    }
                }
            }
        }
        
        return maxHeap.size();
        
    }
}