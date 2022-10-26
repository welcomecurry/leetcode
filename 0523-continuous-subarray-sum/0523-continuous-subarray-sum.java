class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //prefix sum
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Set<Integer> set = new HashSet();

        for (int i = 2; i <= nums.length; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}