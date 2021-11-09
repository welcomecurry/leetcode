class Solution {
    
    class Trie {
        Trie[] children = new Trie[26];
        String word = null;
        int count = 0;
    }
    
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Trie root = new Trie();
        
        for(String word : words)
        {
            char[] w = word.toCharArray();
            Arrays.sort(w);
            
            StringBuilder sb = new StringBuilder();
            sb.append(w[0]);
            
            for(int i = 1; i < w.length; i++)
            {
                if(w[i] != w[i - 1]) sb.append(w[i]);
            }
            
            addWord(sb.toString(), root);
        }
        
        List<Integer> output = new ArrayList<>();
        for(String puzzle : puzzles)
        {
            output.add(search(puzzle, root, 'a'));
        }
        
        return output;
    }
    
    private void addWord(String word, Trie root)
    {
        Trie curr = root;
        
        for(char c : word.toCharArray())
        {
            int ascii = c - 'a';
            
            if(curr.children[ascii] == null)
            {
                curr.children[ascii] = new Trie();
            }
            
            curr = curr.children[ascii];
        }
        
        curr.word = word;
        curr.count++;
    }
    
    private int search(String puzzle, Trie curr, char start)
    {
        int count = 0;
        
        if(curr.word != null && curr.word.indexOf(puzzle.charAt(0)) != -1)
        {
            count += curr.count;
        }
        
        for(char c = start; c <= 'z'; c++)
        {
            if(curr.children[c - 'a'] != null && puzzle.indexOf(c) != -1)
            {
                count += search(puzzle, curr.children[c - 'a'], (char) (c + 1));
            }
        }
        
        return count;
    }
}