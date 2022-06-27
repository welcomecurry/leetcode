class Solution {
    public int minPartitions(String n) {
        //the ans is the highest digit in n
        
        int output = 0;
        
        for(char c : n.toCharArray())
        {
            output = Math.max(output, c - '0');
        }
        
        return output;
    }
}