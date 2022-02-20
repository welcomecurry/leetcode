class Solution {
    public int countEven(int num) {
        //keep starter num at 1 sum digits till num and see if they are equal
        
        int count = 0, starter = 1;
        
        while(starter <= num) if(digitSumIsEven(starter++)) count++;
        
        return count;
    }
    
    private boolean digitSumIsEven(int num)
    {
        int sum = 0;
        
        while(num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        
        return sum % 2 == 0;
    }
}