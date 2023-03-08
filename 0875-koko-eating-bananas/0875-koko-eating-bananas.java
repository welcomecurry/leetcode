class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //binary search
        //find max in piles to set right range value
        //loop while left < right
        //take mid
        //call helper to set if we can eat bananas under h hours given current k
        //if yes set right to mid
        //otherwise set left to mid + 1
        //return right since it will end up on min k
        
        int left = 1, right = findMax(piles);
        
        while(left < right)
        {
            int k = left + (right - left) / 2; //mid
            
            if(canEatUnderH(piles, h, k))
            {
                right = k;
            }
            else
            {
                left = k + 1;
            }
        }
        
        return right;
    }
    
    private int findMax(int[] piles)
    {
        int max = 0;
        
        for(int pile : piles) max = Math.max(max, pile);
        
        return max;
    }
    
    private boolean canEatUnderH(int[] piles, int h, int k)
    {
        int time = 0;
        
        for(int pile : piles) time += (pile - 1) / k + 1;
        
        return time <= h;
    }
}