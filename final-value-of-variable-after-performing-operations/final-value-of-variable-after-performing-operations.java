class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        
        for(String operation : operations)
        {
            int plusIndex = operation.indexOf("+");
            
            if(plusIndex != -1)
            {
                val++;
            }
            else
            {
                val--;
            }
        }
        
        return val;
    }
}