class Solution {

    int[] original;
    int[] curr;
    Random rand;
    public Solution(int[] nums) {
        curr = nums;
        original = nums.clone();
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        curr = original;
        original = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < this.curr.length; i++)
        {
            swap(i, getRandom(i, curr.length));
        }
        return curr;
    }
    
    private void swap(int i, int j)
    {
        int temp = curr[i];
        curr[i] = curr[j];
        curr[j] = temp;
    }
    
    private int getRandom(int min, int max)
    {
        return rand.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */