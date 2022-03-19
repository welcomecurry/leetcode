class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFreq = 0;
    }
    
    //grab our current frequency for x + 1
    //add it to map
    //take max of currentFreq and maxFreq
    //then compute if absent and push onto corresponding frequency stack
    public void push(int x) {
        int currFreq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, currFreq);
        
        if(currFreq > this.maxFreq) this.maxFreq = currFreq;
        
        stackMap.computeIfAbsent(currFreq, f -> new Stack<>()).push(x);
    }
    
    //grab current stack that contains the maxFreq
    //grab popped element, if the currentMaxFreq stack is empty then decrment maxFreq
    //decrement currPop from freqMap and return currPop
    public int pop() {
        Stack<Integer> maxStack = stackMap.get(this.maxFreq);
        int currPop = maxStack.pop();
        
        if(maxStack.isEmpty()) this.maxFreq--;
        
        freqMap.put(currPop, freqMap.get(currPop) - 1);
        
        return currPop;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */