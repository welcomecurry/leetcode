class Solution {
    public int minimizeMax(int[] nums, int p) {
        // Sort the input array in ascending order
        Arrays.sort(nums);
        int n = nums.length;

        // Initialize two pointers for binary search
        int left = 0, right = nums[n-1] - nums[0];

        while (left < right) {
            int mid = (right + left) / 2;
            
            int countPairs = 0;
            
            // Iterate through the array and count pairs with a difference less than or equal to 'mid'
            for (int i = 1; i < n && countPairs < p; i++) {
                if (nums[i] - nums[i-1] <= mid) {
                    i++;  // Move to the next index to avoid double counting
                    countPairs++;
                }
            }

            // If the count of valid pairs is greater than or equal to 'p', update the right boundary
            if (countPairs >= p) {
                right = mid;
            } else {
                // If the count of valid pairs is less than 'p', update the left boundary
                left = mid + 1;
            }
        }

        return left;
    }
}