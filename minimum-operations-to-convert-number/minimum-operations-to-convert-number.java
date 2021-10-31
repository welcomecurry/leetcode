class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        //bfs
        //init operations, queue and set
        //loop through queue
        //poll current element
        //if the element == goal return output
        //if element < 0 || element > 0 || the set contains the element continue
        //add element to set
        //loop through nums and offer all operations onto queue
        //increment operations
        //if we perform bfs without reaching goal return -1
        
        int operations = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int curr = queue.poll();
                
                if(curr == goal) return operations;
                if(curr < 0 || curr > 1000 || set.contains(curr)) continue;
                
                set.add(curr);
                
                for(int num : nums)
                {
                    queue.add(curr + num);
                    queue.add(curr - num);
                    queue.add(curr ^ num);
                }
            }
            operations++;
        }
        
        return -1;
    }
}