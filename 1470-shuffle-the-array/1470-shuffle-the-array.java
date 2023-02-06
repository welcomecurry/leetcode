class Solution {
    public int[] shuffle(int[] nums, int n) {
        //two pointer
        int[] output = new int[nums.length];
        int index = 0, i = 0, j = n;

        while(i < n && j < nums.length) {
            output[index++] = nums[i++];
            output[index++] = nums[j++];
        }

        return output;
    }
}