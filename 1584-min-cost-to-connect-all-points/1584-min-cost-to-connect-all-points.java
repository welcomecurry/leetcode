class Solution {
    public int minCostConnectPoints(int[][] points) {
        //prims algorithm, minimum spanning tree
        
        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        minHeap.add(new int[] {0, 0, 0});
        
        int cost = 0, edges = 0;
        
        while(!minHeap.isEmpty() || edges < points.length - 1)
        {
            int[] curr = minHeap.poll();
            
            if(visited[curr[1]]) continue;
            
            visited[curr[1]] = true;
            cost += curr[2];
            edges++;
            
            for(int i = 0; i < points.length; i++)
            {
                if(!visited[i])
                {
                    minHeap.add(new int[] {curr[1], i, Math.abs(points[curr[1]][0] - points[i][0]) + Math.abs(points[curr[1]][1] - points[i][1])});
                }
            }
        }
        
        return cost;
    }
}