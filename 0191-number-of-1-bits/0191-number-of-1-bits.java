public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //init one bits
        //loop while the number is not zero
        //if number is one increment
        //>> means right shift for signed number
        //>>> means right shift for unsigned number
        
        int oneBits = 0;
        
        while(n != 0)
        {
            oneBits += (n & 1);
            n >>>= 1;
        }
        
        return oneBits;
    }
}