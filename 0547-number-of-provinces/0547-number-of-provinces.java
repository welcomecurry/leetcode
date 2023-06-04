class Solution {
    public int findCircleNum(int[][] isConnected) {
        //dfs
        //loop through and if i and j == 1 add to list
        //init visited array
        //loop through array, if element has not been visited increment provinces and call dfs
        
        List<List<Integer>> list = new ArrayList<>();
        int provinces = 0;
        
        for(int i = 0; i < isConnected.length; i++)
        {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected.length; j++)
            {
                if(i == j) continue;
            
                if(isConnected[i][j] == 1) list.get(i).add(j);
            }
        }
        
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i])
            {
                dfs(list, i, visited);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    private void dfs(List<List<Integer>> list, int i, boolean[] visited)
    {
        visited[i] = true;
        
        for(int neighbour : list.get(i))
        {
            if(!visited[neighbour])
            {
                dfs(list, neighbour, visited);
            }
        }
    }
}