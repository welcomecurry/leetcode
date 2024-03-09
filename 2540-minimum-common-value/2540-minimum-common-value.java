class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        //while current element < either increment and then ret if nums1 == nums2
        int i = 0, j = 0;
        
        while(i < nums1.length && j < nums2.length && nums1[i] != nums2[j]) {
            if(i < nums1.length - 1 && nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        
        return (i == nums1.length || j == nums2.length) || nums1[i] != nums2[j]
            ? -1 : nums1[i];
    }
}