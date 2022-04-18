class Solution {
    public int minimumRounds(int[] tasks) {
        //count occurences
        //if any occurene is 1, cannot complete task
        //otherwise increment rounds with formula
        //return rounds
        
        int rounds = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1) return -1;
            
            rounds += (entry.getValue() + 2) / 3;
        }
        
        return rounds;
    }
}