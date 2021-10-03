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
    public ListNode deleteDuplicates(ListNode head) {
        //init nonDupe and pointer node
        //init treemap, key is the number and value is the occurence, since we want to return sorted
        //loop through head and map occurences of each number
        //loop through treemap
        //if value is 1, add key to node and progress node
        //return nonDupe.next
        
        ListNode nonDupe = new ListNode(-1);
        ListNode pointer = nonDupe;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        while(head != null)
        {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                pointer.next = new ListNode(entry.getKey());
                pointer = pointer.next;
            }
        }
        
        return nonDupe.next;
    }
}