class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //backtracking
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), k, n, 1);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, List<Integer> curr, int k, int n, int start)
    {
        ///base case if curr size == k and n == 0, append to output and return
        //otherwise loop from start to 9
        //make choice, add curr i to curr
        //recurse on i + 1 and n - i
        //undo choice
        
        if(curr.size() == k && n == 0)
        {
            output.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = start; i <= 9; i++)
        {
            curr.add(i);
            backtrack(output, curr, k, n - i, i + 1);
            curr.remove(curr.size() - 1);
        }
        
    }
}