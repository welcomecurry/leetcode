class Solution {
    public int firstMissingPositive(int[] nums) {
        //lloop through the array and add to set
        //loop through from 1 to length
        //if !set.contains(i) return i;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) set.add(i);
        
        int i = 1;
        while(set.contains(i)) {
            i++;
        }
        
        return i;
    }
}