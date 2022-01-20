class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        //binary search
        //loop through and find max of quantities to find right bound
        //loop while left < right
        //init x (mid)
        //if can split quanities given x <= n set right to mid
        //otherwise set left = mid + 1
        //return right since that is the minimized max
        
        int left = 1, right = findMax(quantities);
        
        while(left < right)
        {
            int x = left + (right - left) / 2; //mid
            
            if(canSplitQuantities(quantities, n, x))
            {
                right = x;
            }
            else
            {
                left = x + 1;
            }
        }
        
        return right;
    }
    
    private int findMax(int[] quant)
    {
        int max = 0;
        
        for(int q : quant) max = Math.max(max, q);
        
        return max;
    }
    
    private boolean canSplitQuantities(int[] quantities, int n, int x)
    {
        int total = 0;
        
        for(int q : quantities) total += q % x == 0 ? q / x : q / x + 1;
        
        return total <= n;
    }
}