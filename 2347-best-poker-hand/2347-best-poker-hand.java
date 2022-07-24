class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        //do checks for each hand
        //if all suits equal each other return flush
        //if a number occurs >= 3 return Three of a Kind
        //if a number occurs >= 2 return Pair
        //else return high card
        
        int suitIndex = 1;
        
        while(suitIndex < suits.length && suits[suitIndex] == suits[suitIndex - 1]) {
            suitIndex++;
        }
        
        if(suitIndex == suits.length) return "Flush";
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : ranks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 3) return "Three of a Kind";
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 2) return "Pair";
        }
        
        return "High Card";
    }
}