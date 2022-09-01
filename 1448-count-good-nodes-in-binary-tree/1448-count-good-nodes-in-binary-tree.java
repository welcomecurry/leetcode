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
    int good = 0;
    public int goodNodes(TreeNode root) {
        //preorder dfs, root, left, right
        //return helper
        dfs(root, Integer.MIN_VALUE);
        return good;
    }
    
    private void dfs(TreeNode root, int max)
    {
        //base case if root is null return
        //if root.val >= max, increment good nodes and set max
        //do that for left and right subtrees, preorder traversal
        
        if(root == null)
        {
            return;
        }
        
        if(root.val >= max)
        {
            good++;
            max = root.val;
        }
        
        dfs(root.left, max);
        dfs(root.right, max);
    }
}