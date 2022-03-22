class Solution {
    public String getSmallestString(int n, int k) {
        //init a char array of size n
        //fill char array with all a's and subtract n off k, since a is 1
        //init a index starting at the end of the char array
        //loop through while k >= 26
        //charArr[index--] = 'z'
        //k -= 25, -25 since we already subtracted an 'a' initially
        //when we break out of loop, add remaning char to array, charArr[index] = (char) ('a' + k)
        //return String.valueOf(charArray)
        
        char[] output = new char[n];
        Arrays.fill(output, 'a');
        k -= n;
        
        int index = output.length - 1;
        
        while(k >= 26)
        {
            output[index--] = 'z';
            k -= 25;
        }
        
        output[index] = (char) ('a' + k);
        
        return String.valueOf(output);
    }
}