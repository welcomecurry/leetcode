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
    public ListNode insertionSortList(ListNode head) {
        //terrible solution
        //convert to arr sort then convert back
        
        int len = getLength(head);
        int[] nums = new int[len];
        int index = 0;
        
        ListNode pointer = head;
        
        while(pointer != null)
        {
            nums[index++] = pointer.val;
            pointer = pointer.next;
        }
        
        pointer = head;
        insertionSort(nums);
        
        for(int i : nums)
        {
            pointer.val = i;
            pointer = pointer.next;
        }
        
        return head;
    }
    
    private void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    private int getLength(ListNode head)
    {
        int len = 0;
        
        while(head != null)
        {
            len++;
            head = head.next;
        }
        
        return len;
    }
}