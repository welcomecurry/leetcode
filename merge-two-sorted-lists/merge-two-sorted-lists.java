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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //merge sort, loop while both are not null
        //after initial loop through both and append remaining elements
        
        ListNode output = new ListNode(-1);
        ListNode pointer = output;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                pointer.next = new ListNode(l1.val);
                pointer = pointer.next;
                l1 = l1.next;
            }
            else //l2.val < l1.val
            {
                pointer.next = new ListNode(l2.val);
                pointer = pointer.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null)
        {
            pointer.next = new ListNode(l1.val);
            pointer = pointer.next;
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            pointer.next = new ListNode(l2.val);
            pointer = pointer.next;
            l2 = l2.next;
        }
        
        return output.next;
    }
}