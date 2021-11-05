class Solution {
    public int arrangeCoins(int n) {
        //init row
        //loop through while n >= 0
        //n -= row
        //row++
        //return row - 1 since it is 0 indexed
        
        int row = 1;
        
        while(n >= 0)
        {
            n -= row;
            row++;
        }
        
        return row - 2;
    }
}