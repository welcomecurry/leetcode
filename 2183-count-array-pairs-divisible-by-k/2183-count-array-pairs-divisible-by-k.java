class Solution {
    public long coutPairs(int[] nums, int k) {
        //init map
        //loop through and count occurences of gcd
        //loop through the gcd map  
        //if the current gcd * curr map gcd is divisible by k increment pairs by output
        
        Map<Integer, Integer> map = new HashMap<>();
        long pairs = 0;
        
        for(int num : nums)
        {
            int gcd = greatestCommonDivisor(k, num);
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if(((long) gcd * entry.getKey()) % k == 0) pairs += entry.getValue();
            }
            
            map.put(gcd, map.getOrDefault(gcd, 0) + 1);
        }
        
        
        return pairs;
    }
    
    private int greatestCommonDivisor(int a, int b)
    {
        return a == 0 ? b : greatestCommonDivisor(b % a, a);
    }
}