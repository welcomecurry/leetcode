class Solution {
    public int minimumDeviation(int[] nums) {
        //if we multiply any odd number by 2, it always becomes even
        //therefore, if we multiply every odd number by 2, we can get an all even array
        //then we only need to perform one operation, dividing by 2
        //init a treeset
        //loop through array and add all nums to treeset, if it is odd, add currElement * 2
        //init deviation to Integer.max_val since we are finding min
        //all we need to do is loop and check all deviations while we can, by doing max - min each time
        //loop through the set while true
        //if our max val becomes odd, we have reached end of operations to transform array, so break
        //init maxVal by taking from last val in set
        //take the deviation by taking the min of current deviation and max - min value
        //otherwise, remove the current maxValue from the set and add it / 2 to complete an operation
        //return the deviation
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i : nums)
        {
            if(i % 2 != 0)
            {
                set.add(i * 2);
            }
            else
            {
                set.add(i);
            }
        }
        
        int deviation = Integer.MAX_VALUE;
        
        while(true)
        {
            int maxVal = set.last();        //below, maxVal - minVal
            deviation = Math.min(deviation, maxVal - set.first()); 
            
            if(maxVal % 2 != 0)
            {
                break;
            }
            else
            {
                set.remove(maxVal);
                set.add(maxVal / 2);
            }
        }
        
        return deviation;
    }
}