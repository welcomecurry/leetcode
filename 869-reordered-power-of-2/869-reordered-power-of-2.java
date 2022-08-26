class Solution {
    public boolean reorderedPowerOf2(int N) {
        //we could do all permutations of N but ineffiecient
        //init array that counts frequency of digits in N
        //loop through from 0 to 31, since 2^31 is int max and > 10^9
        //create freq arr for current power
        //if arrays match return true
        //otherwise if we get through loop return false
        
        int[] inputFreq = getFreq(N);
        
        for(int i = 0; i < 31; i++)
        {
            if(Arrays.equals(inputFreq, getFreq((int) Math.pow(2, i))))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private int[] getFreq(int n)
    {
        int[] freq = new int[10]; //max ten digits in 10^9
        
        while(n > 0)
        {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }
}