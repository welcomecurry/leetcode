class Solution {
    public boolean isHappy(int n) {
        //create a hashset to hold computations
        //run algo
        //if hashset contains current number return false
        
        Set<Integer> set = new HashSet<>();
        
        while(n != 1)
        {
            n = sumSquareDigits(n);
            
            if(set.contains(n))
            {
                return false;
            }
            else
            {
                set.add(n);
            }
        }
        
        return true;
    }
    
    private int sumSquareDigits(int n)
    {
        int output = 0;
        
        while(n != 0)
        {
            output += (n % 10) * (n % 10);
            n /= 10;
        }
        
        return output;
    }
}