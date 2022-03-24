class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //greedy
        //sort the array
        //init i and j pointers, i = 0, j = length - 1
        //init numberOfBoats
        //while i <= j
            //if people[i] + people[j] <= limit
                //increment i
            //decrement j
            //increment num of boats
        //return numOfBoats
        
        Arrays.sort(people);
        int i = 0, j = people.length - 1, numberOfBoats = 0;
        
        while(i <= j)
        {
            if(people[i] + people[j] <= limit)
            {
                i++;
            }
            
            j--;
            
            numberOfBoats++;
        }
        
        return numberOfBoats;
    }
}