class Solution {
    public long maxKelements(int[] nums, int k) {
        //put in heap and do operations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        long score = 0;

        for(int i : nums) maxHeap.add(i);

        while(!maxHeap.isEmpty() && k-- > 0) {
            long curr = (long) maxHeap.poll();
            score += curr;
            maxHeap.add((int)Math.ceil(((double) curr) / 3.0));
        }

        return score;
    }
}