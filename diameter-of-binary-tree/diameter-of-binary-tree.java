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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }
    
    private int dfs(TreeNode root)
    {
        //base case if root is not null
        //grab left and right sides
        //calculate diameter on left and right sides
        //return the longest one between left and right sides
        //add 1 for the path connecting the node and its parent
        
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        diameter = Math.max(diameter, left + right);
        
        return 1 + Math.max(left, right);
    }
}