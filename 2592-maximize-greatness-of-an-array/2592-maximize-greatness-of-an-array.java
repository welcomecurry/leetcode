class Solution {
    public int maximizeGreatness(int[] nums) {
        //sort and sliding window
        Arrays.sort(nums);
        int i = 0, j = 0, greatness = 0;
        
        while(j < nums.length) {
            if(nums[j] > nums[i]) {
                greatness++;
                i++;
                j++;
            } else if(nums[j] <= nums[i]) {
                j++;
            }
        }
        
        return greatness;
    }
}


// [1,1,1,2,3,3,5]