class Solution {
    public int minimumSum(int num) {
        //get all digits and sort them
        //return the sum of 1st and 3rd and 2nd and 4th digits to get minimum
        
        int[] digits = new int[4];
        int index = 0;
        
        while(num > 0)
        {
            digits[index++] = num % 10;
            num /= 10;
        }
        
        Arrays.sort(digits);
        
        int num1 = (digits[0] * 10) + digits[2];
        int num2 = (digits[1] * 10) + digits[3];
        
        return num1 + num2;
    }
}