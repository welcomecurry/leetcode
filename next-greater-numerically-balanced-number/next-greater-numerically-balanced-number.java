class Solution {
    public int nextBeautifulNumber(int n) {
        //loop through every number greater than n
        //call helper and count occurences of digits
        //loop through occurences, if current element is not 0 and count[i] != i return false
        
        while(true) if(isBeautiful(++n)) return n;
    }
    
    private boolean isBeautiful(int n)
    {
        int[] count = new int[11];
        
        while(n > 0)
        {
            count[n % 10]++;
            n /= 10;
        }
        
        for(int i = 0; i < count.length; i++)
        {
            if(count[i] != 0 && count[i] != i) return false; //sentient
        }
        
        return true;
    }
}