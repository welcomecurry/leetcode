class RangeFreqQuery {
    Map<Integer, List<Integer>> map;
    
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) 
        {
            map.computeIfAbsent(arr[i], l -> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;
        
        List<Integer> indices = map.get(value);
        
        int l = Collections.binarySearch(indices, left);
        int r = Collections.binarySearch(indices, right);
        
        if(l < 0) l = -l - 1;
        if(r < 0) r = -r - 2;
        
        return r - l + 1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */