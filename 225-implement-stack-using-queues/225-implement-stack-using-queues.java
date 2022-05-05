class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //add to head of queue
        //loop through queue and add poll since head must be last element inserted
        queue.add(x);
        for(int i = 0; i < queue.size() - 1; i++)
        {
            queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */