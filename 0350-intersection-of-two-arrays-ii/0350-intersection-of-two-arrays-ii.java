class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //count occurences of both arrays
        //loop through map, if second map contains the key append the min occurence to result
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int i : nums1) map1.put(i, map1.getOrDefault(i, 0) + 1);
        
        for(int i : nums2) map2.put(i, map2.getOrDefault(i, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                for(int i = 0; i < Math.min(entry.getValue(), map2.get(entry.getKey())); i++) {
                    list.add(entry.getKey());
                }
            }
        }
        
        int[] output = new int[list.size()];
        for(int i = 0; i < list.size(); i++) output[i] = list.get(i);
        
        return output;
    }
}