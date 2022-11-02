class Solution {
    public int minMutation(String start, String end, String[] bank) {
        //bfs
        //init char array that holds choices  A C G T
        //init set to hold items in bank for O(1) lookup
        //base case if the set does not contain the end, return -1
        //init mutations
        //init queue and add start
        //loop while queue is not empty
        //init size
        //loop through size
        //poll current string
        //if current string equals end, return mutations
        //otherwise convert current string to char array
        //loop through all chars in current string
        //grab current char
        //loop through all choices to change current character
        //if the chars are the same, continue to next iteration
        //otherwise update current char
        //convert current char array to string
        //if  set contains current combo, add curr string to queue and remove from set
        //revert current char back to old and go onto next iteration
        //increment mutations
        //return -1 if we complete loop since there is no such mutation
        
        char[] choices = new char[] {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        if(!bankSet.contains(end))
        {
            return -1;
        }
        
        int mutations = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                String currString = queue.poll();
                
                if(currString.equals(end))
                {
                    return mutations;
                }
                
                char[] gene = currString.toCharArray();
                
                for(int i = 0; i < gene.length; i++)
                {
                    char oldChar = gene[i];
                    
                    for(char c : choices)
                    {
                        if(c == gene[i]) continue;
                        
                        gene[i] = c;
                        
                        String newCombination = String.valueOf(gene);
                        
                        if(bankSet.contains(newCombination))
                        {
                            queue.add(newCombination);
                            bankSet.remove(newCombination);
                        }
                        
                        gene[i] = oldChar;
                    }
                }
            }
            mutations++;
        }
        
        return -1;
    }
}