class Solution {
    
    //char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    int output = 0;
    
    public int countVowelStrings(int n) {
        //backtracking
        //call backtrack and return output
        
        backtrack(n, 0);
        return output;
    }
    
    private void backtrack(int n, int index)
    {
        //base case, if n == 0 add to output and return
        //otherwise loop through starting at index
        //recurse on n - 1 and i
        
        if(n == 0)
        {
            output++;
            return;
        }
        
        for(int i = index; i < 5; i++)
        {
            backtrack(n - 1, i);
        }
    }
}