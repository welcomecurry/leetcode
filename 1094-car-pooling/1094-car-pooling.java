class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //create an array of ints size 1001 since  max trips are 1000
        //loop through each element in trips
        //newarr[t[1]] += t[0]; start trip postion is populated with num_passengers
        //newarr[t[2]] -= t[0] once we reach end of trip substact passangers at end postiion
        //loop through newarr and capacity -= num substracting each number from capacity if >= 0 return true
        //if capacity < 0 return false
        //if we get through loop return true
        
        int[] times = new int[1001];
        
        for(int[] trip : trips)
        {
            times[trip[1]] += trip[0];
            times[trip[2]] -= trip[0];
        }
        
        for(int time : times)
        {
            capacity -= time;
            
            if(capacity < 0) return false;
        }
        
        return true;
    }
}