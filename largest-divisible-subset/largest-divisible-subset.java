class Solution {
    int[] memo;
    List<Integer> output;
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //dfs
        Arrays.sort(nums);
        memo = new int[nums.length];
        output = new ArrayList<>();
        Arrays.fill(memo, -1);
        dfs(nums, 0, new ArrayList<>(), 1);
        return output;
    }
    
    private void dfs(int[] nums, int index, List<Integer> curr, int prev)
    {
        //base case if the subset > curr subset change
        //loop from index
        //check if current set size has not been visited with larger set and we meet the mod condition
        //set mem[i] to current size
        //make choice and add current num
        //dfs on index + 1
        //undo choice
        
        if(curr.size() > output.size())
        {
            output = new ArrayList<>(curr);
        }
        
        for(int i = index; i < nums.length; i++)
        {
            if(curr.size() > memo[i] && nums[i] % prev == 0)
            {
                memo[i] = curr.size();
                curr.add(nums[i]);
                dfs(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }
}