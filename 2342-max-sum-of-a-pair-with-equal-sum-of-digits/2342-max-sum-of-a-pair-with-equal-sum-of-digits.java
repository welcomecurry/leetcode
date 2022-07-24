class Solution {
    public int maximumSum(int[] nums) {
        //map sum of digits to max heap of numbers
        //loop through keys and take max sum of 2 polls
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i : nums) {
            map.computeIfAbsent(digitSum(i), p -> new PriorityQueue<Integer>((a, b) -> b - a)).add(i);
        }
        
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> curr = entry.getValue();
            if(curr.size() >= 2) {
                max = Math.max(max, curr.poll() + curr.poll());
            }
        }
        
        return max == Integer.MIN_VALUE ? -1 : max;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}