class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        
        for(int i : nums) 
        {
            this.heap.add(i);
            
            while(this.heap.size() > this.k) 
            {
                this.heap.poll();
            }
        }
    }
    
    public int add(int val) {
        
        this.heap.add(val);
        
        if(this.heap.size() > this.k)
        {
            this.heap.remove();
        }
        
        return this.heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */