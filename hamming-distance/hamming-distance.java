class Solution {
    public int hammingDistance(int x, int y) {
        //init distance
        //xor x and y 
        //the resulting binary number will be 1's where corresponding bits are different.
        //loop while not zero
        //distance += xor & 1, if bit is 1, it satisfies problem condition
        //move over to next bit
        //return distance
        
        int xor = x ^ y, distance = 0;
        
        while(xor != 0)
        {
            distance += xor & 1; //if 1, satisfies problem condition
            xor >>= 1; //move to next bit
        }
        
        return distance;
    }
}