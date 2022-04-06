class Solution {
    public int threeSumMulti(int[] arr, int target) {
        //init result and mod
        //loop through from 0 to length
        //init an array of 101 since 0 <= arr[i] <= 100, to count occurences of numbers at j
        //loop from i + 1 to length
        //since we have i and j, k will be target - arr[i] - arr[j], so we need to look for that
        //so as long as k is in range and count[k] > 0, increment result with count[k]
        //increment count of current number at j for current iteration
        
        int modulo = 1000000007;
        long result = 0;
    
        for(int i = 0; i < arr.length; i++)
        {
            int[] count = new int[101];
            
            for(int j = i + 1; j < arr.length; j++)
            {
                int k = target - arr[i] - arr[j]; //what we need to find to satisfy i+j+k = target
                
                if(k >= 0 && k <= 100 && count[k] > 0) //in bounds and we found what we need
                {
                    result += count[k];
                    result %= modulo;
                }
                count[arr[j]]++; //count occurence for current number
            }
        }
        
        return (int) result;
    }
}