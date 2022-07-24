class NumberContainers {
    
    Map<Integer, TreeSet<Integer>> numMap;
    Map<Integer, Integer> indexMap;

    public NumberContainers() {
        //map number to treeSet
        numMap = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        numMap.computeIfAbsent(number, l -> new TreeSet<>());
        if(indexMap.containsKey(index)) {
            int oldNum = indexMap.get(index);
            numMap.get(oldNum).remove(index);
            indexMap.put(index, number);
            numMap.get(number).add(index);
        } else {
            numMap.get(number).add(index);
            indexMap.put(index, number);
        }
        
    }
    
    public int find(int number) {
        return numMap.containsKey(number) && numMap.get(number).size() > 0 ? numMap.get(number).first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */