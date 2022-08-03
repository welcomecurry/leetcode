class MyCalendar {
    
    TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        this.map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        Integer startFloor = this.map.floorKey(start);
        Integer startCeil = this.map.ceilingKey(start);
        
        if((startFloor == null || start >= this.map.get(startFloor)) && (startCeil == null || end <= startCeil))
        {
            map.put(start, end);
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */