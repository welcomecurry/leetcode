class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //powerset
        
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(output, new ArrayList<>(), nums, 0);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, List<Integer> curr, int[] nums, int index)
    {
        output.add(new ArrayList<>(curr));
        
        for(int i = index; i < nums.length; i++)
        {
            if(i > index && nums[i] == nums[i - 1]) continue;
            
            curr.add(nums[i]);
            backtrack(output, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}