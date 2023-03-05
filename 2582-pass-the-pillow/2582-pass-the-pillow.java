class Solution {
    public int passThePillow(int n, int time) {
        //simulation
        int currPerson = 1;
        boolean right = true;
        while(time-- > 0) {
            if(currPerson == n) right = false; 
            if(currPerson == 1) right = true; 

            if(right) currPerson++;
            else currPerson--;
        }

        return currPerson;
    }
}