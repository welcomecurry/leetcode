class Solution {
    public int brokenCalc(int X, int Y) {
        //instead of making X into Y, we can make Y into X and do the inverse operations
        //dividing by two and adding one
        //init operations
        //loop while Y != X
        //if Y is even divide by two otherwise if it is odd add one
        //increment operations
        //return operations + (X-Y), X-Y since the difference is the remaining operations
        
        int operations = 0;
        
        while(Y > X)
        {
            if(Y % 2 == 0)
            {
                Y /= 2;
            }
            else
            {
                Y++;
            }
            operations++;
        }
        return operations + (X - Y);
    }
}