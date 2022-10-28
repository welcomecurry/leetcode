class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //lovely
        //init output and map
        //loop through strings
        //if we sort the current string and the map contains sorted, add curr
        //if it doesn't put sorted and curr
        //loop thorugh the map, for each value append to arraylist and append to output
        
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs)
        {
            char[] curr = str.toCharArray();
            Arrays.sort(curr);
            String sorted = new String(curr);
            
            map.computeIfAbsent(sorted, l -> new ArrayList<String>()).add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            output.add(entry.getValue());
        }
        
        return output;
    }
}