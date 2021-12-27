class Solution {
    public int findComplement(int num) {
        //set mask to all 1's which is -1
        //shift until mask lines up with leading zeros of num
        //negate mask and & with negation of num
        int mask = -1;
        while((num & mask) != 0)
        {
            mask <<= 1;
        }
        return ~mask & ~num;
    }
}