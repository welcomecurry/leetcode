class Solution {
    public int numberOfSteps (int num) {
        //init steps
        //while num > 0
        //if its even divide by two otherwise decrement by one
        //increment steps
        //return steps
        
        int steps = 0;
        
        while(num > 0)
        {
            if(num % 2 == 0)
            {
                num /= 2;
            }
            else
            {
                num--;
            }
            steps++;
        }
        
        return steps;
    }
}