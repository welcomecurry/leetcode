class Solution {
    public int largestComponentSize(int[] nums) {
        //union find
        //loop through nums, we find an element with a common factor union i,j and i, i / j
        //loop through nums again and keep frequency of the components
        //return the max
        
        Map<Integer, Integer> parent = new HashMap<>();
        
        for(int num : nums)
        {
            for(int i = 2; i * i <= num; i++)
            {
                if(num % i == 0)
                {
                    union(num, i, parent);
                    union(num, num / i, parent);
                }
            }
        }
        
        int largestComponent = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums)
        {
            int findNum = find(num, parent);
            
            freq.put(findNum, freq.getOrDefault(findNum, 0) + 1);
            largestComponent = Math.max(largestComponent, freq.get(findNum));
        }
        
        return largestComponent;
    }
    
    private void union(int n, int m, Map<Integer, Integer> parent)
    {
        int findN = find(n, parent);
        int findM = find(m, parent);
        
        if(findN < findM) parent.put(findM, findN);
        else parent.put(findN, findM);
    }
    
    private int find(int num, Map<Integer, Integer> parent)
    {
        if(parent.get(num) == null) parent.put(num, num);
        
        while(num != parent.get(num)) num = parent.get(num);
        
        return num;
    }
}