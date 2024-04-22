class Solution {
    public int openLock(String[] deadends, String target) {
        //bfs
        //add deadends to hashset for constant lookup
        //init visited hashset and add initial "0000"
        //init queue and add intital "0000"
        //init level
        //loop while queue is not empty
        //poll curr lock position
        //if we have reached a deadend, decrement size and countineu
        //if we have reached the target return the level
        //init a stringbuilder to create next lock position
        //loop from 0 to 4
        //create two string, substrings from 0 to i and add next digit, if 9 move to 0
        //and append rest of the string
        //do the same if == 0 make it 9 otherwise decrement and append rest of string
        //if visted and deadends do not contain, s1 or s2 add them to visited and queue
        
        if(target.equals("0000")) return 0;
        
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
                
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size > 0) {
                String currPos = queue.poll();
                
                if(deadEnds.contains(currPos)) {
                    size--;
                    continue;
                }
                
                if(currPos.equals(target)) {
                    return level;
                }
                
                StringBuilder sb = new StringBuilder(currPos);
                
                for(int i = 0; i < 4; i++) {
                    char currDigit = sb.charAt(i);
                    
                    String s1 = sb.substring(0, i) + (currDigit == '9' ? 0 : currDigit - '0' + 1) + sb.substring(i + 1);
                    
                    String s2 = sb.substring(0, i) + (currDigit == '0' ? 9 : currDigit - '0' - 1) + sb.substring(i + 1);
                    
                    if(!visited.contains(s1) && !deadEnds.contains(s1)) {
                        visited.add(s1);
                        queue.add(s1);
                    }
                    
                    if(!visited.contains(s2) && !deadEnds.contains(s2)) {
                        visited.add(s2);
                        queue.add(s2);
                    }
                }
                
                size--;
            }
            
            level++;
        }
        
        return -1;
    }
}