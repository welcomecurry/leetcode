class Solution {
    public long zeroFilledSubarray(int[] nums) {
        //loop through, everytime we encounter a 0, increment number of 0 times, otherwise reset
        long output = 0, currZeros = 0;
        
        for(int i : nums) {
            if(i == 0) {
                output += ++currZeros;
            } else {
                currZeros = 0;
            }
        }
        
        return output;
    }
}