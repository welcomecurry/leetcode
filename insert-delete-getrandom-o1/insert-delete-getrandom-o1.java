class RandomizedSet {

    TreeMap<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    
    public RandomizedSet() {
        map = new TreeMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int index = map.remove(val);
        int lastElement = list.remove(list.size() - 1);
        
        if(val != lastElement)
        {
            list.set(index, lastElement);
            map.put(lastElement, index);
        }
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */