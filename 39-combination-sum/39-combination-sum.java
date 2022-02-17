class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, candidates, target, new ArrayList<>(), 0);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, int[] candidates, int remaining, List<Integer> curr, int index)
    {
        //base case => if remaining == 0 add curr to output and return
        //base case => if remaining < 0 return
        //loop through from index to arr.length
        //add current element to curr
        //call backtrack on remaining - current element
        //when function returns, remove last element
        
        if(remaining == 0)
        {
            output.add(new ArrayList<>(curr));
            return;
        }
        
        if(remaining < 0) return;
        
        for(int i = index; i < candidates.length; i++)
        {
            curr.add(candidates[i]);
            backtrack(output, candidates, remaining - candidates[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}