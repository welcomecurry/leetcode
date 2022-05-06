class Solution {
    class Node {
        int occur;
        char c;
        
        public Node(char character, int occurence) {
            c = character;
            occur = occurence;
        }
    }
    public String removeDuplicates(String s, int k) {
        //stack
        //loop thorugh string
        //if the stack is empty or peek != curr char add to stack
        //else add to stack char and peek val + 1
        //if peek == k, while peek > 0 pop off stack
        //append all chars to stringbuilder and reverse string
        
        Stack<Node> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(stack.isEmpty() || stack.peek().c != c) stack.push(new Node(c, 1));
            else stack.push(new Node(c, stack.peek().occur + 1));
            
            if(stack.peek().occur == k)
            {
                int temp = k;
                
                while(temp-- > 0) stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop().c);
        
        return sb.reverse().toString();
    }
}