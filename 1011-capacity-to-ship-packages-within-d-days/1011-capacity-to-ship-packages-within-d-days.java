class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //binary search
        //init left to max of weights and right to sum of weights
        //loop while left < right
        //init weight (mid)
        //if we can pack on curr weight set right to mid
        //otherwise set left to mid + 1
        //return right as it will be the min
        
        int left = 0, right = 0;
        
        for(int w : weights)
        {
            left = Math.max(left, w);
            right += w;
        }
        
        while(left < right)
        {
            int capacity = left + (right - left) / 2;
            
            if(canShip(weights, days, capacity))
            {
                right = capacity;
            }
            else
            {
                left = capacity + 1;
            }
        }
        
        return right;
    }
    
    private boolean canShip(int[] weights, int totalDays, int capacity)
    {
        //init days to 1 and currWeight to 0
        //loop through weights
        //if currWeight + w > capacity increment days and reset currWeight
        //increment currWeight by w
        //return if days <= totalDays
        
        int days = 1, currWeight = 0;
        
        for(int w : weights)
        {
            if(currWeight + w > capacity)
            {
                days++;
                currWeight = 0;
            }
            
            currWeight += w;
        }
        
        return days <= totalDays;
    }
}