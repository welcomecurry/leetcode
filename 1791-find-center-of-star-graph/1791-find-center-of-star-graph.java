class Solution {
    public int findCenter(int[][] edges) {
        //loop through edges and count occurences of values and add to set
        //loop through map, if value == set.size() - 1 return key
        //otherwise if we get through return -1
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] edge : edges) {
            set.add(edge[0]);
            set.add(edge[1]);
            
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == set.size() - 1) return entry.getKey();
        }
        
        return -1;
    }
}