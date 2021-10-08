class Trie {

    Node root;
    
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = this.root;
        
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a']= new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node searched = getNode(word);
        return searched != null && searched.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    private Node getNode(String word)
    {
        Node curr = this.root;
        
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                return null;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr;
    }
}

class Node {
    char val;
    Node[] children;
    boolean isWord;
    
    public Node(char c)
    {
        this.val = c;
        children = new Node[26];
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */