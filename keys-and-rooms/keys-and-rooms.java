class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //init set to hold visited rooms
        //add first room to visited
        //init stack for rooms to visit
        //add the first room to the stack
        //loop while stack is not empty
        //grab current room from pop
        //for each key in the current room
        //if the set does not contain the key add it to the set and push key to stack
        //return if set.size() == rooms.size(), if it does we have visited all rooms since we have all the keys in our set
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while(!stack.isEmpty())
        {
            List<Integer> currRoom = rooms.get(stack.pop());
            
            for(int key : currRoom)
            {
                if(!visited.contains(key))
                {
                    visited.add(key);
                    stack.push(key);
                }
            }
        }
        
        return visited.size() == rooms.size();
    }
}