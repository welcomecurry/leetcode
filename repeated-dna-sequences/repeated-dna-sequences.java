class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //create hashmap
        //create result arrayList
        //loop through the string till length -9 since we want string length 10 and dont want to go out of bounds
        //string currentSequence = s.substring(i, i + 10)
        //add to map and count occurences
        //loop through the map 
        //if value > 1 add key to list
        //return list
        
        Map<String, Integer> map = new HashMap<>();
        List<String> output = new ArrayList<>();
        
        for(int i = 0; i < s.length() - 9; i++)
        {
            String currSequence = s.substring(i, i + 10);
            map.put(currSequence, map.getOrDefault(currSequence, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1) output.add(entry.getKey());
        }
        
        return output;
    }
}