class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j <= target && j <= k * i; j++) {
                for (int a = 0; a < k; a++) {
                    if (j >= a + 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - a - 1]) % MOD;
                    }
                }
            }
        }
        return dp[n][target];
    }
}