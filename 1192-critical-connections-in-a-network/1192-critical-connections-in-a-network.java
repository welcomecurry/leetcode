class Solution {
    
    int time = 0;
    List<List<Integer>> result;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //dfs marking depths (timestamps)
        //create adjacency list
        //init boolean of size n to store visited and timestamp array of size n
        //init output
        //call dfs passing in adj matrix, visited, timestamps, starting vertex and prev timestamp
        //return output
        
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for(List<Integer> edge : connections) //create adj matrix
        {
            int a = edge.get(0);
            int b = edge.get(1);
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        boolean[] visited = new boolean[n];
        int[] timestamps = new int[n];
        result = new ArrayList<>();
        
        dfs(adj, visited, timestamps, 0, -1);
        
        return result;
    }
    
    private void dfs(List<Integer>[] adj, boolean[] visited, int[] timestamps, int vertex, int prev)
    {
        //mark current node as visited and increment timestamp for currnode
        //retrieve current timestamp
        //loop through neighbours of curr node
        //if current neighbour is prev we can skip
        //if the neighbour is not visited call dfs
        //timestamp at current vertex is min of curr and neighbour
        //if current timestamp < neighbours time stamp, it is a critical connection so append to res
        
        visited[vertex] = true;
        timestamps[vertex] = time++;
        int currTimestamp = timestamps[vertex];
        
        for(int neighbour : adj[vertex])
        {
            if(neighbour == prev) continue;
            
            if(!visited[neighbour]) dfs(adj, visited, timestamps, neighbour, vertex);
            
            timestamps[vertex] = Math.min(timestamps[vertex], timestamps[neighbour]);
            
            //is a critical connection
            if(currTimestamp < timestamps[neighbour]) result.add(Arrays.asList(vertex, neighbour));
        }
    }
}