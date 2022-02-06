class Bitset {
    int size;
    Set<Integer> zeros, ones;
    public Bitset(int size) {
        this.size = size;
        zeros = new HashSet<>();
        ones = new HashSet<>();
        
        for(int i = 0; i < size; i++) zeros.add(i);
    }
    
    public void fix(int idx) {
        zeros.remove(idx);
        ones.add(idx);
    }
    
    public void unfix(int idx) {
        ones.remove(idx);
        zeros.add(idx);
    }
    
    public void flip() {
        //just swap sets
        Set<Integer> temp = zeros;
        zeros = ones;
        ones = temp;
    }
    
    public boolean all() {
        return ones.size() == size;
    }
    
    public boolean one() {
        return ones.size() >= 1;
    }
    
    public int count() {
        return ones.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < size; i++)
        {
            if(zeros.contains(i)) sb.append('0');
            else if(ones.contains(i)) sb.append('1');
        }
        
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */