class Solution {
    public List<List<String>> partition(String s) {
        //backtracking
        List<List<String>> output = new ArrayList<>();
        backtrack(output, s, new ArrayList<>(), 0);
        return output;
    }
    
    private void backtrack(List<List<String>> output, String s, List<String> curr, int index)
    {
        //base case, if index == s.length and curr.size() > 0, add curr to output and return
        //loop through starting at index
        //if the current substring is a palindrome, make choice by adding string to curr
        //backtrack on i + 1
        //undo choice
        
        if(index == s.length() && curr.size() > 0)
        {
            output.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = index; i < s.length(); i++)
        {
            String str = s.substring(index, i + 1);
            if(isPalindrome(str))
            {
                curr.add(str); //make choice
                backtrack(output, s, curr, i + 1); //backtrack
                curr.remove(curr.size() - 1); //undo choice
            }
        }
    }
    
    private boolean isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        
        while(i < j)
        {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        
        return true;
    }
}