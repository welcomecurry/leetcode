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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //slow and fast pointer
        //progress fast to node before n
        //if fast is null then we have case n == length so return head.next
        //loop till fast hits last node, while progressing slow and fast
        //when fast hits last node, slow will be at node before removal
        //remove node at slow
        //return head
        
        ListNode slow = head, fast = head;
        
        for(int i = 0; i < n; i++)
        {
            fast = fast.next;
        }
        
        if(fast == null) return head.next;
        
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}