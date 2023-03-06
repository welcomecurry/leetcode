class Solution {
    public int findKthPositive(int[] arr, int k) {
        //init set
        //init a missing arraylist
        //loop through arr and add all nums to set
        //loop through from 1 to last elment in arr + k
            //if set does not contain i, add to missing list
        //return missing.get(k-1), -1 since 0 indexed
        
        Set<Integer> set = new HashSet<>();
        List<Integer> missingNums = new ArrayList<>();
        
        for(int i : arr)
        {
            set.add(i);
        }
        
        for(int i = 1; i <= arr[arr.length - 1] + k; i++)
        {
            if(!set.contains(i))
            {
                missingNums.add(i);
            }
        }
        
        return missingNums.get(k - 1); //k - 1 since 0 indexed, if k = 5 we want to return .get(4)
    }
}