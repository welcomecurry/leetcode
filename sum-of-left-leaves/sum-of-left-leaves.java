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
    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private void dfs(TreeNode root)
    {
        //base check  if root is null return
        //check if root.left is a leaf node if it is add root.left.val  to sum variable
        //recurse down left and right
        
        if(root == null) return;
        
        if(isLeaf(root.left)) result += root.left.val;
        
        dfs(root.left);
        dfs(root.right);
    }
    
    private boolean isLeaf(TreeNode node)
    {
        if(node == null) return false;
        
        if(node.left == null && node.right == null) return true;
        
        return false;
    }
}