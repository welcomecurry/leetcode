class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //greedy
        //sort by a's then b's
        //for the first n / 2 add b
        //for the rest add a
        
        int minCost = 0;
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        
        for(int i = 0; i < costs.length; i++)
        {
            minCost += i < costs.length / 2 ? costs[i][1] : costs[i][0];
        }
        
        return minCost;
    }
}