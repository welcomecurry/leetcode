/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //bfs starting from right since right most node points to null
        
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node prevNode = null;
            
            while(size-- > 0)
            {
                Node currNode = queue.poll();
                
                currNode.next = prevNode;
                prevNode = currNode;
                
                if(currNode.right != null) queue.add(currNode.right);
                
                if(currNode.left != null) queue.add(currNode.left);
            }
        }
        
        return root;
    }
}