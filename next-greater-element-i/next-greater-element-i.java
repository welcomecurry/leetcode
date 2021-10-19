class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //mark indices of elements in nums2
        //loop through nums1 and grab index of current element in nums2
        //if we find a greater number set in nums2 set to output and break
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[nums1.length];
        Arrays.fill(output, -1);
        
        for(int i = 0; i < nums2.length; i++)
        {
            map.put(nums2[i], i);
        }
        
        for(int i = 0; i < nums1.length; i++)
        {
            for(int j = map.get(nums1[i]); j < nums2.length; j++)
            {
                if(nums2[j] > nums1[i])
                {
                    output[i] = nums2[j];
                    break;
                }
            }
        }
        
        return output;
    }
}