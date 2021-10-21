class Solution {
    public String frequencySort(String s) {
        //loop through chracters in string and store in hashmap
        //create a max heap (a,b) map.getb - map.geta
        //add all values into maxheap
        //while the heap is not empty
        //get heap.poll loop through while i < heap.poll add that many chars to new string
        //return new string
        
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        maxHeap.addAll(map.keySet()); //add everything from map into heap
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty())
        {
            char currLetter = maxHeap.poll();
            
            for(int i = 0; i < map.get(currLetter); i++) sb.append(currLetter);
        }
        
        return sb.toString();
    }
}