class Solution {
    public int bitwiseComplement(int n) {
        //xor each bit
        
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