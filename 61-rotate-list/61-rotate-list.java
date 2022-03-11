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
    public ListNode rotateRight(ListNode head, int k) {
        //base case
        //calculate length
        //make a circular list
        //mod k with the length and k - length
        //loop up to kth elemnt
        //set head to curr.next and curr.next = null to break circlular list
        //return head
        
        if(head == null) return null;
        
        int length = 1;
        
        ListNode curr = head;
        
        while(curr.next != null)
        {
            length++;
            curr = curr.next;
        }
        
        curr.next = head; //create circular list
        
        k %= length;
        k = length - k;
        
        while(k-- > 0) curr = curr.next;
        
        head = curr.next;
        curr.next = null; //break circular list
        
        return head;
        
    }
}