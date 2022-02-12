class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs
        //base cases if list does not contain endWord return 0 and if begin == end return 1
        //init queue of strings and level
        //init set out of wordList for O(1) lookup
        //add begin into queue
        //loop while queue is not empty
        //get size and loop while > 0
        //poll word
        //we will replace each char one by one with [a,z] and check if it exists in our dictionary
        //loop through currWord length
        //grab temp char, to replace at end of iterations
        //loop through each letter and check if the dict contains it
        //if it does add to queue and remove from dict
        //if it equals endWord return level + 1
        //replace cached temp
        //increment level
        //return 0 if we never find endword
        
        if(!wordList.contains(endWord)) return 0;
        else if(beginWord.equals(endWord)) return 1;
        
        int level = 1; //beginWord is first level
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        queue.add(beginWord);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                char[] currWord = queue.poll().toCharArray();
                
                for(int i = 0; i < currWord.length; i++)
                {
                    char temp = currWord[i];
                    
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        currWord[i] = c;
                        
                        String newWord = new String(currWord);
                        
                        if(dict.contains(newWord))
                        {
                            if(newWord.equals(endWord)) return level + 1;
                            
                            queue.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    
                    currWord[i] = temp;
                }
            }
            
            level++;
        }
        
        return 0;
    }
}