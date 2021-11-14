class CombinationIterator {
    
    int index = 0;
    List<String> combos = new ArrayList<>();
    
    public CombinationIterator(String characters, int combinationLength) {
        backtrack(characters, combinationLength, new StringBuilder(), 0);
    }
    
    private void backtrack(String chars, int length, StringBuilder curr, int index)
    {
        //base case if curr.length == length, add to combos and return
        
        if(curr.length() == length)
        {
            combos.add(curr.toString());
            return;
        }
        
        for(int i = index; i < chars.length(); i++)
        {
            curr.append(chars.charAt(i));
            backtrack(chars, length, curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    
    public String next() {
        return combos.get(index++);
    }
    
    public boolean hasNext() {
        return index < combos.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */