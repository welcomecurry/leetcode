class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //init result
        //call backtrack passing in n and k
        //return
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currCombo, int n, int k)
    {
        //base case if currCombo.size() == k append and return
        //otherwise backtrack
        
        if(currCombo.size() == k)
        {
            result.add(new ArrayList<>(currCombo));
            return;
        }
        else
        {
            for(int i = 1; i <= n; i++)
            {
                if(!currCombo.contains(i)) 
                {
                    currCombo.add(i);
                    backtrack(result, currCombo, i, k);
                    currCombo.remove(currCombo.size() - 1);
                }
            }
        }
    }
}