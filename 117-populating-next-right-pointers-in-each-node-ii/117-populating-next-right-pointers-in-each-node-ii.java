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
        //bfs right to left
        
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node prev = null;
            
            while(size-- > 0)
            {
                Node currNode = queue.poll();
                
                currNode.next = prev;
                prev = currNode;
                
                if(currNode.right != null) queue.add(currNode.right);
                
                if(currNode.left != null) queue.add(currNode.left);
            }
        }
        
        return root;
    }
}