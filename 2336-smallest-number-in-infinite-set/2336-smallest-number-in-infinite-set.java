class SmallestInfiniteSet {

    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        //max calls 1000 so add 1-1000 in treeset
        set = new TreeSet<>();
        
        for(int i = 1; i <= 1000; i++) set.add(i);
    }
    
    public int popSmallest() {
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */