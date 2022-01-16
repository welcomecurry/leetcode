class Solution {
    public int maxDistToClosest(int[] seats) {
        //keep 2 vars, currentLength and maxDist
        //loop through the arrray
        //if the element is 1
            //if currentLength == -1
                //maxDist = i
        //else
            //maxDist = max(maxDist, (i - l) / 2)
        //set our length to i
        //if we get to last seat and it is 0 that means we need to calculate another length
        //so take max of maxDist and length - 1 - length
        //return maxDist
    
        int currentLength = -1;
        int maxDistance = 0;
        
        for(int i = 0; i < seats.length; i++)
        {
            if(seats[i] == 1)
            {
                if(currentLength == -1)
                {
                    maxDistance = i;
                }
                else
                {
                    maxDistance = Math.max(maxDistance, (i - currentLength) / 2);
                }
                currentLength = i;
            }
        }
        
        if(seats[seats.length - 1] == 0)
        {
            maxDistance = Math.max(maxDistance, seats.length - 1 - currentLength);
        }
        
        return maxDistance;
    }
}