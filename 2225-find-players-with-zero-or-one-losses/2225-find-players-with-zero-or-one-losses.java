class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        //loop through and count losses for each player
        //loop through again, if the losses map does not contain player, add to non lost
        //loop through losses map and if the value is 1 append oto lost one
        
        Arrays.sort(matches, (a,b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Integer> noLost = new TreeSet<>();
        
        List<Integer> oneLost = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        for(int[] match : matches) map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        
        for(int[] match : matches) if(!map.containsKey(match[0])) noLost.add(match[0]);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1) oneLost.add(entry.getKey());
        }
        
        output.add(new ArrayList<>(noLost));
        output.add(oneLost);
        
        return output;
    }
}