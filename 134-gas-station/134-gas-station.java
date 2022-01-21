class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //have a current difference, total and index to be returned
        //loop through arrays
        // tank = gas[i]-cost[i]
        // add to total
        // if tank < 0 index = i + 1 and reset tank
        //check at end if total >= return index else return -1
        
        int tank = 0;
        int total = 0;
        int index = 0;
        
        for(int i = 0; i < gas.length; i++)
        {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            
            if(tank < 0) 
            {
                tank = 0;
                index = i + 1;
            }
        }
        
        return total >= 0 ? index : -1;
    }
}