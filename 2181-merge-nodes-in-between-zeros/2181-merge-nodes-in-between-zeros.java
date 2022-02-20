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
    public ListNode mergeNodes(ListNode head) {
        //loop until we encounter a zero
        //while the current node is not a zero increment values and append to output
        
        ListNode output = new ListNode(-1);
        ListNode pointer = output;
        
        while(head != null)
        {
            if(head.val == 0 && head.next != null)
            {
                int sum = 0;
                head = head.next;
                while(head != null && head.val != 0)
                {
                    sum += head.val;
                    head = head.next;
                }
                
                pointer.next = new ListNode(sum);
                pointer = pointer.next;
            }
            else
            {
                head = head.next;
            }
        }
        
        return output.next;
    }
}