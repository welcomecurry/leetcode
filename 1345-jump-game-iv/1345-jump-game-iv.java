class Solution {
    public int minJumps(int[] arr) {
        //map all values to indices
        //perform bfs
        //init queue
        //add zeroth indice
        //loop
        //poll off indice and init arr element from curr
        //if not valid, not in bounds and visited continue
        //check if we are on last element if yes return steps
        //set current element to visited
        //add i + 1 and i - 1 jumps to queue if valid
        //loop through each indice and add to queue then remove key from map
        //increment steps at end of looop
        //return steps
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            map.computeIfAbsent(arr[i], l -> new ArrayList<>()).add(i);
        }
        
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int currIndex = queue.poll();
                int currElement = arr[currIndex];
                
                if(!valid(arr, currIndex)) continue;
                
                if(currIndex == arr.length - 1) return steps; //last element
                
                arr[currIndex] = Integer.MAX_VALUE;
                
                if(valid(arr, currIndex + 1)) queue.add(currIndex + 1);
                
                if(valid(arr, currIndex - 1)) queue.add(currIndex - 1);
                
                for(int index : map.getOrDefault(currElement, Collections.emptyList()))
                {
                    if(valid(arr, index)) queue.add(index);
                }
                
                map.remove(currElement); //remove from map
            }
            steps++;
        }
        
        return steps;
    }
    
    private boolean valid(int[] arr, int index)
    {
        return index >= 0 && index < arr.length && arr[index] != Integer.MAX_VALUE;
    }
}