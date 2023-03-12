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
    public ListNode mergeKLists(ListNode[] lists) {
        //init minHeap
        //loop thorugh all listNode lists and add to minHeap
        //init result
        //loop thorugh minHeap and append to result
        //return result
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(ListNode list : lists)
        {
            while(list != null)
            {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        
        while(!minHeap.isEmpty())
        {
            pointer.next = new ListNode(minHeap.poll());
            pointer = pointer.next;
        }
        
        return result.next;
    }
}