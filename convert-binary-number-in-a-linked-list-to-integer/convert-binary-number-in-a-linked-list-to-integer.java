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
    public int getDecimalValue(ListNode head) {
        StringBuilder num = new StringBuilder();
        
        while(head != null)
        {
            num.append(head.val);
            head = head.next;
        }
        
        return Integer.parseInt(num.toString(), 2);
    }
}