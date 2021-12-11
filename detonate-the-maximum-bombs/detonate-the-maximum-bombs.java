class Solution {
    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public int maximumDetonation(int[][] bombs) {
        //dfs
        //create graph of bombs that detonate (intersect) in its radius
        //loop through bombs again and perform dfs on each bomb and take the max
        
        for(int i = 0; i < bombs.length; i++)
        {
            int[] bomb1 = bombs[i];
            for(int j = 0; j < bombs.length; j++)
            {
                if(i == j) continue;
                
                int[] bomb2 = bombs[j];
                
                if(intersects(bomb1[0], bomb1[1], bomb1[2], bomb2[0], bomb2[1]))
                {
                    graph.computeIfAbsent(i, d -> new ArrayList<>()).add(j);
                }
            }
        }
        
        int maxBombDetonation = 0;
        
        for(int i = 0; i < bombs.length; i++)
        {
            int currBombDetonationRadius = dfs(i, new boolean[bombs.length]);
            
            //improve performance
            if(currBombDetonationRadius == bombs.length) return currBombDetonationRadius;
            
            maxBombDetonation = Math.max(maxBombDetonation, currBombDetonationRadius);
        }
        
        return maxBombDetonation;
    }
    
    private int dfs(int node, boolean[] visited)
    {
        //base check if we have visited the node return 0
        //otherwise set current node as visited
        //loop through nodes of current node
        //perform dfs
        //return bombDetonationRadius
        
        if(visited[node]) return 0;
        
        visited[node] = true;
        
        int currBombDetonationRadius = 1;
        
        for(int neighbour : graph.getOrDefault(node, new ArrayList<>()))
        {
            currBombDetonationRadius += dfs(neighbour, visited);
        }
        
        return currBombDetonationRadius;
    }
    
    private boolean intersects(long x1, long y1, long rad, long x2, long y2)
    {
        long dist = ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        long radius = rad * rad;
        
        return radius >= dist;
    }
}