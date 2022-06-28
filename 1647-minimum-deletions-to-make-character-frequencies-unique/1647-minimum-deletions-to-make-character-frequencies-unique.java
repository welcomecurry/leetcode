class Solution {
    public int minDeletions(String s) {
        //create charmap with occurences of character
        //create maxheap
        //loop through charmap and add anything that is > 0
        //loop through heap
        //keep current element
        //if currentelement == heap.peek
        //decrement currentelemtn and add to heap
        //incerement deletions
        //return deletions
        
        int[] charMap = new int[26];
        
        for(char c : s.toCharArray())
        {
            charMap[c - 'a']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i : charMap)
        {
            if(i != 0) maxHeap.add(i);
        }
        
        int deletions = 0;
        
        while(!maxHeap.isEmpty())
        {
            int current = maxHeap.poll();
            
            if(maxHeap.isEmpty())
            {
                return deletions;
            }
            
            if(current == maxHeap.peek())
            {
                if(current > 1)
                {
                    maxHeap.add(current - 1);
                }
                deletions++;
            }
        }
        
        return deletions;
    }
}