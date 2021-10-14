class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minVals;
    
    public MinStack() {
        stack = new Stack<>();
        minVals = new Stack<>();
    }
    
    public void push(int val) {
        if(minVals.isEmpty() || val <= minVals.peek())
        {
            minVals.push(val);
        }
        
        stack.push(val);
    }
    
    public void pop() {
        if(minVals.peek().equals(stack.peek()))
        {
            minVals.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVals.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */