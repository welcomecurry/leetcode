class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        //binary search
        //start from 1 to 10^5
        //loop while left < right
        //init mid
        //if we can cover the distance with the current number set minSpeed and right 
        //otherwise set left to mid + 1
        //return minSpeed
        
        int left = 1, right = 10000000, minSpeed = -1;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(canCoverDistance(dist, hour, mid))
            {
                minSpeed = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return minSpeed;
    }
    
    private boolean canCoverDistance(int[] dist, double hour, int mid)
    {
        double speed = 0.0;
        for(int d : dist)
        {
            speed = Math.ceil(speed);
            speed += (double) d / (double) mid;        
        }
        
        return speed <= hour;
    }
}