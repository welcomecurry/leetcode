class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        //add all nums to treeset
        //loop through remove moveFrom and insert moveTo
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i : nums) treeSet.add(i);
        
        for(int i = 0; i < moveFrom.length; i++) {
            treeSet.remove(moveFrom[i]);
            treeSet.add(moveTo[i]);
        }
                
        return new ArrayList<>(treeSet);
    }
}