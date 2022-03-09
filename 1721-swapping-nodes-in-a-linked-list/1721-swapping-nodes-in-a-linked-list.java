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
    public ListNode swapNodes(ListNode head, int k) {
        //init arraylist and add all elements in head to it
        //get nodes to be swapped, k - 1 and length - k
        //swap them
        //loop through list and change values in head and return head
        
        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        
        while(pointer != null)
        {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        
        int front = list.get(k - 1), back = list.get(list.size() - k);
        
        list.set(k - 1, back);
        list.set(list.size() - k, front);
        
        pointer = head;
        
        for(int i : list)
        {
            pointer.val = i;
            pointer = pointer.next;
        }
        
        return head;
    }
}