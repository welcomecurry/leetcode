class Solution {
    public int minMoves2(int[] nums) {
        //sort the array, the middle element is the target
        //element to the left of middle we need to increment and elements to right we need to decrement
        //loop through array, moves += abs of mid elements and current element
        //return moves
        
        Arrays.sort(nums);
        int moves = 0, mid = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++)
        {
            moves += Math.abs(nums[mid] - nums[i]);
        }
        
        return moves;
    }
}