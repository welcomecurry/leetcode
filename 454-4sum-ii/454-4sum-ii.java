class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //compute all possible sums of A and B and place in hashamp
        //loop thorugh c and d and check if the hashmap contains the opposite and increment the cnt
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < B.length; j++)
            {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < C.length; j++)
            {
                int sum = -(C[i] + D[j]);
                if(map.containsKey(sum)) count += map.get(sum);
            }
        }
        
        return count;
    }
}