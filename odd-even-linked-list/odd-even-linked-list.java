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
    public ListNode oddEvenList(ListNode head) {
        //base cheack if head == null return head
        //create 3 listnodes
        //odd which is set to head
        //even which is set to head.next
        //evenHead which is set to even
        //while even is not null and even.next is not null
        //odd.next = even.next => odd.next is assinged to next odd element
        //odd = odd.next => odd pointer is now at odd val
        //even.next = odd.next => even.next is assigned to the next even element
        //even = even.next => even pointer is now at even val
        //merge odd and even lists => odd.next = evenHead
        //return head since our odd was intitally assigned to head
        
        if(head == null) return head;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}