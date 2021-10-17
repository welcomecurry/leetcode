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
    int output = 0;
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return 0;
        
        findPaths(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return output;
    }
    
    private void findPaths(TreeNode root, int sum, int targetSum)
    {
        if(root == null) return;
        
        sum += root.val;
        
        if(sum == targetSum) output++;
        
        findPaths(root.left, sum, targetSum);
        findPaths(root.right, sum, targetSum);
    }
}