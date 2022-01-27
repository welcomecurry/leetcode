class Solution {
    
    public class TrieNode {
        TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[2]; // left or right, 0 or 1
        }
    }
    
    TrieNode root;
    
    public int findMaximumXOR(int[] nums) {
        //trie
        //loop through nums and insert each 32 bit num into trie
        //then for each number in the trie we want to xor each bit and find the negated bit
        //do that for every number and return the max
        
        int max = Integer.MIN_VALUE;
        root = new TrieNode();
        
        for(int num : nums) insert(num);
                
        for(int num : nums) max = Math.max(max, find(num));
        
        return max;
    }
    
    private void insert(int num)
    {
        TrieNode curr = root;
        int bitIndex = 31;
        
        while(bitIndex >= 0)
        {
            int mask = 1 << bitIndex;
            int bitVal = (mask & num) == 0 ? 0 : 1;
            
            TrieNode node = curr.children[bitVal];
            
            if(node == null)
            {
                node = new TrieNode();
                curr.children[bitVal] = node;
            }
            
            curr = node;
            bitIndex--;
        }
    }
    
    private int find(int num)
    {
        TrieNode curr = root;
        int output = 0, bitIndex = 31;
        
        while(bitIndex >= 0)
        {
            int mask = 1 << bitIndex;
            int currBitVal = (mask & num) == 0 ? 0 : 1;
            int requiredBitVal = currBitVal ^ 1;
            
            TrieNode node = curr;
            
            if(node.children[requiredBitVal] != null)
            {
                output += mask;
                curr = node.children[requiredBitVal];
            }
            else
            {
                curr = node.children[currBitVal];
            }
            
            bitIndex--;
        }
        
        return output;
    }
}