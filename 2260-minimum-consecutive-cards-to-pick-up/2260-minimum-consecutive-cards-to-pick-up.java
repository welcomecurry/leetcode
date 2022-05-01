class Solution {
    public int minimumCardPickup(int[] cards) {
        //loop through and mark indices of same values
        //loop through indices and take min distance of consectutive cards
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < cards.length; i++) 
        {
            map.computeIfAbsent(cards[i], l -> new ArrayList<>()).add(i);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            List<Integer> indices = entry.getValue();
            
            if(indices.size() <= 1) continue;
            
            for(int i = 1; i < indices.size(); i++)
            {
                min = Math.min(min, (indices.get(i) - indices.get(i - 1)) + 1);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}