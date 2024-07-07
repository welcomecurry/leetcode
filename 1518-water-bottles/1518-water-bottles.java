class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int count = numBottles;
        while(numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            int full = numBottles / numExchange;
            
            count += full;
            numBottles = remainder + full;
        }
        
        return count;
    }
}