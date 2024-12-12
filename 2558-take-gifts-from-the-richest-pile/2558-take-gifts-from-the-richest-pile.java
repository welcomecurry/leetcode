class Solution {
    public long pickGifts(int[] gifts, int k) {
        //add to heap
        //poll while k > 0 and take floor of sqrt and add back
        //take sum

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i : gifts) maxHeap.add(i);

        while(k > 0) {
            int curr = maxHeap.poll();
            maxHeap.add((int) Math.floor(Math.sqrt(curr)));
            k--;
        }

        long total = 0;

        while(!maxHeap.isEmpty()) total += maxHeap.poll();

        return total;
    }
}