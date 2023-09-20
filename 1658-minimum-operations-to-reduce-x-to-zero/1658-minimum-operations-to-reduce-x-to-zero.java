class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0, j = 0, res = -1;
        int target = -x;
        for (int a : nums) target += a;
        if (target < 0) return -1;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (sum > target) {
                sum -= nums[j++];
            }
            if (sum == target) {
                res = Math.max(res, i - j + 1);    
            }
        }
        return res == -1 ? -1 : n - res;
    }
}