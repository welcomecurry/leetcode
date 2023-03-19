class WordDictionary {
    
    public class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        
        TrieNode(char c) 
        {
            val = c;
            isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    
    public WordDictionary() {
        //trie
        root = new TrieNode('!');
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode(c);
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        //perform bfs on trie to find word
        
        TrieNode r = root;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(r);
        
        int level = 0;
        
        while(!queue.isEmpty() && level <= word.length())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                TrieNode curr = queue.poll();
                
                if(level == word.length())
                {
                    if(curr.isWord) return true;
                    else continue;
                }
                
                char currChar = word.charAt(level);
                
                if(currChar == '.')
                {
                    for(TrieNode node : curr.children)
                    {
                        if(node != null) queue.add(node);
                    }
                }
                else if(curr.children[currChar - 'a'] != null)
                {
                    queue.add(curr.children[currChar - 'a']);
                }
            }
            level++;
        }
        
        return false;
    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */