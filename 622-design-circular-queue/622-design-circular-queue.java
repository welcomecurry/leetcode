class MyCircularQueue {
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    int size, maxSize;
    ListNode head = null, tail = null;
    
    public MyCircularQueue(int k) {
        this.size = 0;
        this.maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) //cannot add so return false
        {
            return false;
        }
        
        ListNode node = new ListNode(value);
        if(isEmpty()) //queue is empty so set both head and tail to the node
        {
            this.head = this.tail = node;
        }
        else //vanilla case, set tail to node and progress tail
        {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        
        this.size++; //increment size of queue
        return true; //we added element so return true
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false; //cannot remove element if queue is empty
        
        this.head = this.head.next; //just move head over
        this.size--; //decrement size since we removed an element
        return true; //we removed element so return true
    }
    
    public int Front() {
        return this.size > 0 ? head.val : -1;
    }
    
    public int Rear() {
        return this.size > 0 ? tail.val : -1;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */