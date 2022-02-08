class Solution {
    public int addDigits(int num) {
        //loop through while num >= 10
        //call helper on num that adds the digits
        //return num
        
        while(num >= 10)
        {
            num = add(num);
        }
        
        return num;
    }
    
    private int add(int num)
    {
        //pop off digits and add them together
        int sum = 0;
        
        while(num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}