class Solution {
    public int numberOfBeams(String[] bank) {
        //init output and prev
        //loop through bank
        //count the ones in current string
        //if the prev > 0, (there exists a 1) then output += oneCount * prev
        //set prev to oneCount
        
        int output = 0, prev = 0;
        
        for(String b : bank)
        {
            int oneCount = 0;
            
            for(char c : b.toCharArray()) if(c == '1') oneCount++;
            
            if(oneCount > 0)
            {
                output += oneCount * prev;
                prev = oneCount;
            }
        }
        
        return output;
    }
}