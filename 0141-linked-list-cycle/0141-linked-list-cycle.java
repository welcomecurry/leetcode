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
    public boolean hasCycle(ListNode head) {
        //slow and fast pointer
        //loop while fast is not null and fast.next is not null
        //progress fast by 2 and slow by 1
        //if the two nodes equal each other then there is a cycle
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow.equals(fast)) return true;
        }
        
        return false;
    }
}