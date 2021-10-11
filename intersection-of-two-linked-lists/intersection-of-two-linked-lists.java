/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //init hashset and populate all nodes in headA
        //loop through headB if the set contains the same node, return it
        //otherwise if we get through loop there is not intersection so return null
        
        Set<ListNode> set = new HashSet<>();
        
        while(headA != null)
        {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null)
        {
            if(set.contains(headB))
            {
                return headB;
            }
            
            headB = headB.next;
        }
        
        return null;
    }
}