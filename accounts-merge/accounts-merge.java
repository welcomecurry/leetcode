class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        
        for(List<String> account : accounts)
        {
            String userName = account.get(0);
            Set<String> neighbours = new HashSet<>(account);
            neighbours.remove(userName);
            
            for(int i = 1; i < account.size(); i++)
            {
                String email = account.get(i);
                
                if(!graph.containsKey(email))
                {
                    graph.put(email, new HashSet<>());
                }
                
                graph.get(email).addAll(neighbours);
                owners.put(email, userName);
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> output = new ArrayList<>();
        
        for(String email : owners.keySet())
        {
            if(!visited.contains(email))
            {
                List<String> curr = new ArrayList<>();
                dfs(graph, email, visited, curr);
                Collections.sort(curr);
                curr.add(0, owners.get(email));
                output.add(curr);
            }
        }
        
        return output;
    }
    
    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> curr)
    {
        curr.add(email);
        visited.add(email);
        
        for(String neighbour : graph.get(email))
        {
            if(!visited.contains(neighbour))
            {
                dfs(graph, neighbour, visited, curr);
            }
        }
    }
}