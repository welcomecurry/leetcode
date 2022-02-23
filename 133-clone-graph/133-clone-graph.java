/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //bfs
        //base case to check if node is null
        //init map to check visited
        //init queue
        //add node
        //bfs
        //loop while quue is not empty
        //poll curr node
        //loop through children
        //if we have not visited the child, add child to queue and mark as visited
        //copy the neihbour
        //return visited.get(node)
        
        if(node == null) return null;
        
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(node, new Node(node.val));
        queue.add(node);
        
        while(!queue.isEmpty())
        {
            Node currNode = queue.poll();
            
            for(Node neighbor : currNode.neighbors)
            {
                if(!visited.containsKey(neighbor))
                {
                    visited.put(neighbor, new Node(neighbor.val)); //clone
                    queue.add(neighbor);
                }
                
                visited.get(currNode).neighbors.add(visited.get(neighbor)); //copy
            }
        }
        
        return visited.get(node);
    }
}