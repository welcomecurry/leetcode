class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //count in-degrees of every vertex, those that have 0 at the end are part of the answer
        
        List<Integer> output = new ArrayList<>();
        boolean[] inDegrees = new boolean[n];
        
        for(List<Integer> edge : edges)
        {
            inDegrees[edge.get(1)] = true; //second element is to_i
        }
        
        for(int i = 0; i < inDegrees.length; i++)
        {
            if(!inDegrees[i]) output.add(i);
        }
        
        return output;
    }
}