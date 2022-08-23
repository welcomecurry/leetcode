class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) return true;
        
        ArrayList<Integer> store = new ArrayList<>();
        
        // for storing the value of linkedlist into arraylist
        ListNode curr = head;
        while(curr!=null){
            store.add(curr.val);
            curr = curr.next;
        }
        
        // for checking the arraylist to be paliandromic or not
        for(int i = 0; i < store.size()/2; i++){
            if(store.get(i)!=store.get(store.size()-1-i)) return false;
        }
        return true;
    }
}