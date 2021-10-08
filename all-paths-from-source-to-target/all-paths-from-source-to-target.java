class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        dfs(graph, path, output, 0);
        return output;
    }
    
    private void dfs(int[][] graph, List<Integer> path, List<List<Integer>> output, int node)
    {
        if(node == graph.length - 1)
        {
            output.add(new ArrayList<>(path));
        }
        
        for(int n : graph[node])
        {
            path.add(n);
            dfs(graph, path, output, n);
            path.remove(path.size() - 1);
        }
    }
}