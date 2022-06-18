class WordFilter {
    Trie root;
    String[] A;

    public WordFilter(String[] w) {
        root = new Trie();
        A = w;
        for (int i = 0; i < w.length; i++) {
            root.addWord(i, w[i]);
        }
    }
    
    public int f(String prefix, String suffix) {
        List<Integer> words = root.getWordsFromPrefix(prefix);
        if (words.size() > 0 && words.get(0) == -1) return -1;
        for (int i = words.size() - 1; i >= 0; i--) {
            if (A[words.get(i)].endsWith(suffix)) {
                return words.get(i);
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode('#');
    }
    public List<Integer> getWordsFromPrefix(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return List.of(-1);
            }
            cur = cur.children.get(c);
        }
        return cur.words;
    }
    public void addWord(int i, String w) {
        TrieNode cur = root;
        for (char c : w.toCharArray()) {
            cur.words.add(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
        }
        cur.words.add(i);
    }
    
    class TrieNode {
        char sym;
        List<Integer> words;
        Map<Character, TrieNode> children;
        TrieNode(char c) {
            sym = c;
            words = new ArrayList<>();
            children = new HashMap<>();
        }
    }
}