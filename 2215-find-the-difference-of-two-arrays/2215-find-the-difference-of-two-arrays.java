class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //init output
        //init set to hold nums1 and another for nums2
        //loop through nums2 if the set contains nums1 remove from set
        //do same for nums1
        //loop through set and populate result
        
        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        
        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i);
        
        for(int i : nums2)
        {
            if(set1.contains(i)) set1.remove(i);
        }
        
        for(int i : nums1)
        {
            if(set2.contains(i)) set2.remove(i);
        }
        
        output.add(new ArrayList<>(set1));
        output.add(new ArrayList<>(set2));
        
        return output;
    }
}