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
    public ListNode deleteMiddle(ListNode head) {
        
        int length = 0;
        ListNode pointer = head;
        
        while(pointer != null)
        {
            length++;
            pointer = pointer.next;
        }
        
        if(length == 1) return head.next;
        
        int mid = (length / 2) - 1;
        pointer = head;
        
        while(pointer != null && pointer.next != null)
        {
            if(mid == 0)
            {
                pointer.next = pointer.next.next;
            }
            else
            {
                pointer = pointer.next;
            }
            mid--;
        }
        
        return head;
    }
}