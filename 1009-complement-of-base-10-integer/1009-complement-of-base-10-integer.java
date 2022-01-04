class Solution {
    public int bitwiseComplement(int n) {
        //xor each bit
        //keep N set to n and keep shifting to right till 0 so we know when to terminate loop
        //keep xor'ing each bit with mask to complement it and shift it each time
        if(n == 0) return 1;
        
        int N = n, mask = 1;
        
        while(N > 0)
        {
            n ^= mask;
            mask <<= 1;
            N >>= 1;
        }
        
        return n;
    }
}