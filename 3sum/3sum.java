class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort array
        //init result
        //loop through from 0 to length - 2
        //init j to i + 1 and k to end of array
        //while j < k
        //if i + j + k == 0 add to list and increment and decrement
        //if i + j + k > 0 decrement k, since sorted an decreasing
        //else if < 0 increment j, since sorted and increasing
        //return result
        
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k)
            {
                int curr = nums[i] + nums[j] + nums[k];
                
                if(curr == 0)
                {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(curr > 0)
                {
                    k--;
                }
                else //curr < 0
                {
                    j++;
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}