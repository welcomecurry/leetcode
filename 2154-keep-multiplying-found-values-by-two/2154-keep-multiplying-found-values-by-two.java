class Solution {
    public int findFinalValue(int[] nums, int original) {
        //loop through and add everyhthing to set
        //do steps while current num is not in set and ret that num
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        
        while(set.contains(original)) original *= 2;
        
        return original;
    }
}