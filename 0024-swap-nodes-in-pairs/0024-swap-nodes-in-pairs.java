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
    public ListNode swapPairs(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
        for(int i = 1; i < list.size(); i += 2)
        {
            int temp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, temp);
        }
        
        ListNode output = new ListNode(-1);
        ListNode pointer = output;
        
        for(int i : list)
        {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }
        
        return output.next;
    }
}