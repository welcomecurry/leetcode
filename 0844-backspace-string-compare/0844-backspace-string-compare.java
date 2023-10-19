class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String s)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(c != '#')
            {
                stack.push(c);
            }
            else if(!stack.isEmpty())
            {
                stack.pop();
            }
        }
        
        return String.valueOf(stack);
    }
}