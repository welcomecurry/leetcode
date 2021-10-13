/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //create stack and output
        //loop thorugh head
        //push current node on stack and progress head
        //if the stack size >= k
        //loop while stack is not empty
        //set top element.next to null so we just have the node
        //set pointer to popped value and progress pointer
        //if there are remaining elements in the stack add to pointer
        //return output
        
        Stack<ListNode> stack = new Stack<>();
        ListNode output = new ListNode(-1);
        ListNode pointer = output;
        
        while(head != null)
        {
            stack.push(head);
            head = head.next;
            
            if(stack.size() >= k)
            {
                while(!stack.isEmpty())
                {
                    stack.peek().next = null;
                    pointer.next = stack.pop();
                    pointer = pointer.next;
                }
            }
        }
        
        while(!stack.isEmpty())
        {
            pointer.next = stack.pop();
        }
        
        return output.next;
    }
}