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
    public ListNode sortList(ListNode head) {
        //if head == null or head.next ==  null return head => if our head has 0 or 1 element return that list
        //get middle node from helper
        //ListNode left = sortList(head)
        //ListNode right = sortList(mid)
        //return merge(left, right)
        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode mid = middleNode(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2)
    {
        //same algorithm of merge 2 lists
        
        ListNode merged = new ListNode(-1);
        ListNode current = merged;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                current.next = l1;
                l1 = l1.next;
            }
            else
            {
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        if(l1 != null)
        {
            current.next = l1;
        }
        
        if(l2 != null)
        {
            current.next = l2;
        }
        
        return merged.next;
    }
    
     private ListNode middleNode(ListNode head) {
        // lloop through the list to get count of elements
        // loop through to get to count / 2
        // head = count / 2
        // return head
        
            ListNode slow = head, fast = head, mid;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            mid = slow.next;
            slow.next = null;
            return mid;
    }
}