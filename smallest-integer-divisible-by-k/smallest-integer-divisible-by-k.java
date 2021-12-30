class Solution {
    public int smallestRepunitDivByK(int k) {
        //if divisble by 2 or 5 return -1 since impossible
        // otherwise check if divisible by one
        //keep appending 1's until divisible otherwize return -1
        if(k % 2 == 0 || k % 5 == 0) return -1;
        
        int div = 1, num = 1;
        while(num % k != 0)
        {
            num = (num * 10 + 1) % k;
            div++;
        }
        
        return div;
    }
}