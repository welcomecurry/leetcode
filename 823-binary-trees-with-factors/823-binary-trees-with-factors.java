class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        //sort the array
        //init map
        //each integer A[i] will always have one tree with only itself
        //if A[i] has divisor (a) in the map, and if A[i]/a also in the map
        //then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree
        //the number of such tree is map.get(a) * map.get(A[i]/a)
        //sum over the map
        
        Arrays.sort(arr);
        
        Map<Integer, Long> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            long currCount = 1; //each interger in the array is its own tree so set to one
            
            for(int j = 0; j < i; j++)
            {
                if(arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) //is a factor
                {
                    currCount += map.get(arr[j]) * map.get(arr[i] / arr[j]);
                }
            }
            map.put(arr[i], currCount); //add count of trees for current element
        }
        
        long result = 0;
        
        for(Map.Entry<Integer, Long> entry : map.entrySet())
        {
            result += entry.getValue();
        }
        
        return (int) (result % (1000000000 + 7));
    }
}