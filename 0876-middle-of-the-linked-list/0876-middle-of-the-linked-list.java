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
    public ListNode middleNode(ListNode head) {
        //optimal
        //two pointers slow and fast start at head
        //slow progresses one and fast progresses 2
        //when fast == null or fast.next == null 
        //return slow since slow is going half the speed and will end up in the middle once           fast is null
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}