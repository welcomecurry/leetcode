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
    public void reorderList(ListNode head) {
        //base check if head is null return
        //loop through the list and add elements in arraylist
        //create 3 vars i, left, right, i is current index, left is 1 and right in arrSize()-1 and reset pointer to head
        //loop through while i < arr.size()
        //if i is even node.next = arr.get(left++)
        //else if i is odd node.next = arr.get(right--)
        //progress node
        //increment i
        //at end of loop set pointer.next to null otherwise there will be a cycle
        
        if(head == null) return;
        
        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        
        while(pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        
        int i = 1, left = 1, right = list.size() - 1;
        pointer = head;
        
        while(i < list.size()) {
            if(i % 2 == 0) {
                pointer.next = new ListNode(list.get(left++));         
            }
            else {
                pointer.next = new ListNode(list.get(right--));
            }
            
            pointer = pointer.next;
            i++;
        }
        
        pointer.next = null;
    }
}