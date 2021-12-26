class Solution {
    public boolean isSameAfterReversals(int num) {
        //reverse twice and check if same
        int rev = reverse(num);
        rev = reverse(rev);
        return rev == num;
    }
    
    private int reverse(int num)
    {
        int rev = 0;
        
        while(num > 0)
        {
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }
        
        return rev;
    }
}