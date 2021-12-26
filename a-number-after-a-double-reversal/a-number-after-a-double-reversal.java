class Solution {
    public boolean isSameAfterReversals(int num) {
        //all we have to check if number is 0 and does not have trailing 0's
        //if there are no trailing 0's it will be same after 2 reversals
        return num == 0 || (num % 10) > 0;
    }
}