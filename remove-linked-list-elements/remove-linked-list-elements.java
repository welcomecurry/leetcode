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
    public ListNode removeElements(ListNode head, int val) {
        //loop till node before val then set pointer
        
        if(head == null) return head;
        
        ListNode pointer = head;
        
        while(pointer != null && pointer.next != null)
        {
            if(pointer.next.val == val)
            {
                pointer.next = pointer.next.next; //remove
            }
            else
            {
                pointer = pointer.next;
            }
        }
        
        return head.val == val ? head.next : head;
    }
}