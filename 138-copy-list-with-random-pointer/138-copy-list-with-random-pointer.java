/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //if head is null return null
        //init map, new head, pointer, and copy list
        //loop through pointer and put currNode in key and cloned node in value
        //reset pointer and copy
        //loop through pointer again
        //copy.random = map.get(current.random), we are retreiving from reference
        //just progress nodes
        //return newHead
        
        if(head == null)
        {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        
        Node copiedList = new Node(-1);
        Node pointer = head;
        Node copyPointer = copiedList;
        
        while(pointer != null)
        {
            copyPointer.next = new Node(pointer.val); //init new node in copy list
            copyPointer = copyPointer.next; //progress copy pointer
            map.put(pointer, copyPointer); //map current pointer reference to new node 
            pointer = pointer.next; //progress pointer
        }
        
        pointer = head;
        copyPointer = copiedList.next; //.next since we init it to -1
        
        while(pointer != null)
        {
            copyPointer.random = map.get(pointer.random); //new random is the references pointer
            pointer = pointer.next;
            copyPointer = copyPointer.next;
        }
        
        return copiedList.next;
    }
}