class Solution {
    public String simplifyPath(String path) {
        //split string at '/'
        //init a stack and stringBuilder
        //loop through array
        //".." means going up a directory, "." means nothing
        //if the current element is not .. and . and _, push onto stack
        //if the current element is .. and the stack is not empty, pop off stack
        //if the stack is empty we can just return "/"
        //since the stack is in reverse order we need to carefully construct string
        //append .pop() at beginning of string and then append "/" at beginning of string
        //if the string is empty we can return "/" otherwise return the string
        
        
        String[] modifiedPath = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(String s : modifiedPath)
        {
            if(!s.equals(".") && !s.equals("..") && !s.equals(""))
            {
                stack.push(s);
            }
            else if(s.equals("..") && !stack.isEmpty())
            {
                stack.pop();
            }
        }
        
        while(!stack.isEmpty())
        {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}