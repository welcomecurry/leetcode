class MyQueue {

    Stack<Integer> stack;
    
    public MyQueue() {
        this.stack = new Stack<>();    
    }
    
    public void push(int x) {
        //init temp stack
        //push all elements onto temp
        //push x onto stack
        //push all elements in temp to stack
        
        Stack<Integer> temp = new Stack<>();
        
        while(!this.stack.isEmpty())
        {
            temp.push(this.stack.pop());
        }
        
        this.stack.push(x);
        
        while(!temp.isEmpty())
        {
            this.stack.push(temp.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */