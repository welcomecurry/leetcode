// TreeMap Solution
// 1. Use treemap to store the <start, +count> or <end, -count> pairs
// 2. The sum fo treemap values is the the number of in progress events
// Time: Init: O(1), book: O(N)
// Space: O(N)
class MyCalendarThree {
    // Store the <start, +count> or <end, -count> pairs
    private TreeMap<Integer, Integer> map;
    
    // Time: O(1)
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    // Time: O(N)
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int res = 0;   // track max the number of in progress events
        int sum = 0;  // track the number of in progress events
        for (int val : map.values()) {
            sum += val;
            res = Math.max(res, sum);
        }
        return res;
    }
}