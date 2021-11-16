class Solution {
    public int findKthNumber(int m, int n, int k) {
        //binary search
        
        int left = 1, right = m * n;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(enough(m, n, k, mid))
            {
                right = mid - 1; 
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean enough(int m, int n, int k, int element)
    {
        int count = 0;
        
        for(int i = 1; i <= m; i++)
        {
            count += Math.min(element / i, n);
        }
        
        return count >= k;
    }
}