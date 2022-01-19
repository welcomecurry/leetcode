/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //check if there is a cycle
        //if slow and fast equal each other
        //reset slow to head 
        //while slow != fast
        //progress slow and fast one by one
        //once they meet at the tail
        //return slow
        //if we get through the loop return null since there is no cycle
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                slow = head;
                
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        
        return null;
    }
}