class Solution {
    public long[] sumOfThree(long num) {
        //only possible if the num is divisble by 3
        
        if(num % 3 != 0) return new long[0];
        
        num /= 3;
        
        return new long[] { num - 1, num, num + 1 };
    }
}