class Solution {
    public int countPairs(int[] deliciousness) {
        //two sum variation
        //loop through meals
        //the max 2 power is 2^21 so if found in map increment
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, mod = 1000000007;
        
        for(int meal : deliciousness)
        {
            int power = 1;
            
            for(int i = 0; i <= 21; i++)
            {
                if(map.containsKey(power - meal))
                {
                    count += map.get(power - meal);
                    count %= mod;
                }
                
                power *= 2;   
            }
            
            map.put(meal, map.getOrDefault(meal, 0) + 1);
        }
        
        return count;
    }
}