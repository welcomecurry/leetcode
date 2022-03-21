class Solution {
    public List<Integer> partitionLabels(String s) {
        //loop through the string and map last indices of each character
        //create start and end vars
        //loop through the string again
        //end is the max of current end and last indice of current character
        //if i == end that means we found a partition
        //so add end - start + 1 and set start to end + 1
        //return output
        
        int[] lastIndices = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            lastIndices[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> output = new ArrayList<>();
        int start = 0, end = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            
            if(i == end)
            {
                output.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return output;
    }
}