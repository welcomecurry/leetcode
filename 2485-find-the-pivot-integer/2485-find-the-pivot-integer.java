class Solution {
    public int pivotInteger(int n) {
        //get total sum
        //loop through 1 to n and decrement current element from total sum
        //if currSum == total return i
        //return -1
        
        int totalSum = n * (n + 1) / 2; //thanks gauss
        int currSum = 0;
        
        for(int i = 1; i <= n; i++) {
            totalSum -= i;
            if(totalSum == currSum) return i;
            if(currSum > totalSum) return -1;
            currSum += i;
        }
        
        return -1;
    }
}