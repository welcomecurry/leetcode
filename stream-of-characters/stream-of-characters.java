class StreamChecker {
    //trie
    //insert words in reverse
    //insert query's into trie and loop through stream backwards to find a suffix
    
    TrieNode root;
    StringBuilder stream;
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        
        for(String word : words) insert(word);
    }
    
    private void insert(String word)
    {
        TrieNode currNode = root;
        word = new StringBuilder(word).reverse().toString(); //reverse string for reverse insertion
        
        for(char c : word.toCharArray())
        {
            if(currNode.children[c - 'a'] == null)
            {
                currNode.children[c - 'a'] = new TrieNode();
            }
            currNode = currNode.children[c - 'a'];
        }
        currNode.isSuff = true; //set end of suffix
    }
    
    public boolean query(char letter) {
        stream.append(letter);
        TrieNode search = root;
        
        for(int i = stream.length() - 1; i >= 0; i--)
        {            
            if(search == null) return false; //no valid suffix
            
            char currLetter = stream.charAt(i);
            search = search.children[currLetter - 'a']; //move to next next
            
            if(search != null && search.isSuff) return true; //found a suffix!
        }
        
        return false;
    }
    
    class TrieNode {
        
        boolean isSuff = false;
        TrieNode[] children;
        
        public TrieNode() 
        {
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */