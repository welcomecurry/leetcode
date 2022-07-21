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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l, r;
        
        while(left < right)
        {
            l = getPos(head, left);
            r = getPos(head, right);
            
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
            
            left++;
            right--;
        }
        
        return head;
    }
    
    private ListNode getPos(ListNode head, int index)
    {
        ListNode temp = head;
        
        for(int i = 0; i < index - 1; i++)
        {
            temp = temp.next;
        }
        
        return temp;
    }
}