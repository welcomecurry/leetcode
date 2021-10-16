class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int num : nums)
        {
            Integer greaterThanOrEqual = set.ceiling(num);
            
            if(greaterThanOrEqual == null)
            {
                set.add(num);
            }
            else
            {
                set.remove(greaterThanOrEqual);
                set.add(num);
            }
        }
        
        return set.size();
    }
}