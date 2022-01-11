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
    public int sumRootToLeaf(TreeNode root) {
       //preorder
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int sum)
    {
        //base case if root is null return 0
        //sum * 2 + root.val
        //if we are on a leaf return sum
        //return left and right sum
        
        if(root == null) return 0;
        
        sum = (sum * 2) + root.val;
        
        if(root.left == null && root.right == null) return sum;
        
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}