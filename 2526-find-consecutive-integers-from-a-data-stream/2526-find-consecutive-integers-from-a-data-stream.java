class DataStream {
    //set value and num elements
    int value, k, numElements, lastK;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.numElements = 0;
        this.lastK = 0;
    }
    
    public boolean consec(int num) {
        //increment num elements
        //if num == value increment lastK
        //else lastK == 0
        //if num elements < k return false
        //if lastK == k return true
        numElements++;

        if(num == this.value) lastK++;
        else lastK = 0;

        if(numElements < this.k) return false;

        if(lastK >= k) return true;

        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */