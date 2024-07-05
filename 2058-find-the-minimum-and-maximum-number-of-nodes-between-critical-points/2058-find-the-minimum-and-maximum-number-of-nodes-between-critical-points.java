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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        //loop thorugh and if we find a minima or maxima add to list
        //loop thorugh list to find min, max is just the last element - first element
        
        int index = 1;
        ListNode prev = head;
        head = head.next;
        List<Integer> list = new ArrayList<>();
        
        while(head.next != null)
        {
            if((head.val < prev.val && head.val < head.next.val) || (head.val > prev.val && head.val > head.next.val))
            {
                list.add(index);
            }
            prev = head;
            head = head.next;
            index++;
        }
        
        if(list.size() < 2) return new int[] {-1, -1};
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < list.size(); i++)
        {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        
        return new int[] { min, list.get(list.size() - 1) - list.get(0) };
    }
}