class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(output, candidates, target, new ArrayList<>(), -1);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, int[] candidates, int remaining, List<Integer> curr, int index)
    {
        
        if(remaining == 0)
        {
            output.add(new ArrayList<>(curr));
            return;
        }
    
        if(remaining < 0) return;
        
        for(int i = index + 1; i < candidates.length; i++)
        {
            if(i > index + 1 && candidates[i] == candidates[i - 1]) continue;
            
            curr.add(candidates[i]);
            backtrack(output, candidates, remaining - candidates[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}