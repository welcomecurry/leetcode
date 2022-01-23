class Solution {
    public int countElements(int[] nums) {
        //get max and min and count elements within range
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, count = 0;
        
        for(int num : nums)
        {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        for(int num : nums) if(min < num && max > num) count++;
        
        return count;
    }
}