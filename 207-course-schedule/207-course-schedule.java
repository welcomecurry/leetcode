class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //dfs to check if there is a cycle
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); 
        }
        
        for(int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        
        //array of visited (0 -> unvisited, 1 -> visited, 2 -> completed)
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, graph, visited)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int node, List<List<Integer>> graph, int[] visited) {
        //base check if visited return false, if completed return true
        //mark current node as visited
        //perform dfs on conneted nodes
        //mark node as completed
        
        if(visited[node] == 1) return false;
        
        if(visited[node] == 2) return true;
        
        visited[node] = 1;
        
        for(int neighbour : graph.get(node)) {
            if(!dfs(neighbour, graph, visited)) return false;
        }
        
        visited[node] = 2;
        
        return true;
    }
}