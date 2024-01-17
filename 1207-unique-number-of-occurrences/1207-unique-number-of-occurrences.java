class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // create hashmap and hashset and loop through the elements and add to hashmap
        
        // loop through hashmap if hashmap contains occurence return false
        // thother wise return true
        
        HashMap<Integer, Integer> map = new HashMap();
        HashSet<Integer> set = new HashSet();
        
        for(int i : arr)
        {
            if(!map.containsKey(i))
            {
                map.put(i, 0);
            }
            else
            {
                map.put(i, map.get(i) + 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(set.contains(value))
            {
                return false;
            }
            set.add(value);
        }
        
        return true;
        
    }
}