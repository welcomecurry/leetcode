/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head == null) return null;
        
        Node tail = new Node(-1);
        
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        
        
        while(!stack.isEmpty())
        {
            Node curr = stack.pop();
            Node next = curr.next;
            Node child = curr.child;
            
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
            
            if(next != null)
            {
                stack.push(next);
            }
            
            if(child != null)
            {
                stack.push(child);
                curr.child = null;
            }
        }
        
        head.prev = null;
        return head;
    }
}