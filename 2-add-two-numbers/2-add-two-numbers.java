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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //init return and pointer node
        //init carry
        //loop through while l1 or l2 is not null
        //init sum with carry
        //if l1 is not null, add to sum and progress node
        //if l2 is not null, add to sum and progress node
        //add sum % 10 to return node and progress pointer
        //carry = sum / 10
        //if we have a remaining carry, add it to return node
        //return return.next node
        
        ListNode output = new ListNode(-1);
        ListNode pointer = output;
        
        int carry = 0;
        
        while(l1 != null || l2 != null)
        {
            int sum = carry;
            
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum / 10;
        }
        
        if(carry > 0)
        {
            pointer.next = new ListNode(carry);
            pointer = pointer.next;
        }
        
        return output.next;
    }
}