class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        long sum = 0;
        long maxSum = 0;

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            sum += arr[j];
            if (j - i + 1 == k) {
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= arr[i];
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            j++;
        }

        return maxSum;
    }
}
