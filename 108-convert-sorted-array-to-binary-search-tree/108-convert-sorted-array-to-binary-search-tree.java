/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //return helper, passing in nums, 0 to length - 1
        
        return convert(nums, 0, nums.length - 1);
    }
    
    private TreeNode convert(int[] nums, int start, int end)
    {
        //base case, if start > end, return null
        //root is the middle element, everything to left of root is left subtree and everything
        //to the right is the right subtree
        //init root to middle element
        //left subtree is from start to mid - 1
        //right subtree is from mid + 1 to end
        //return root
        
        if(start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = convert(nums, start, mid - 1);
        root.right = convert(nums, mid + 1, end);
        
        return root;
    }
}