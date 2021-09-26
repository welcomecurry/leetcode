class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //init result list
        //call backtrack passing in nums, new ArrayList, result
        //return result
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> currPermutation, List<List<Integer>> result)
    {
        //base case if current permutaion reached nums.length, append to result
        //otherwise loop from 0 to nums.length
        //if we have not seen the current element
        //set current element to seen and append currElement to currPermutation
        //backtrack
        //after return, undo choice, revert current element to unseen and remove
        //last element
        
        if(currPermutation.size() == nums.length)
        {
            result.add(new ArrayList<>(currPermutation));
            return;
        }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(!currPermutation.contains(nums[i]))
                {
                    currPermutation.add(nums[i]); //make choice
                    backtrack(nums, currPermutation, result);
                    currPermutation.remove(currPermutation.size() - 1); //undo choice
                }
            }
        }
    }
}