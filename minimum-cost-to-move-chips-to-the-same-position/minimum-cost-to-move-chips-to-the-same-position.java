class Solution {
    public int minCostToMoveChips(int[] position) {
        //count number of even positions
        //return even if < odd or return odd positions
        int evens = 0;
        for(int i : position) evens += i % 2 == 0 ? 1 : 0;
        return evens <= position.length / 2 ? evens : position.length - evens;
    }
}