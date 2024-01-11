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
    public int maxAncestorDiff(TreeNode root) {
        //perform postorder and find min and max on each root to leaf path
        //once we get to end of path return the difference
        
        return dfs(root, root.val, root.val);
    }
    
    private int dfs(TreeNode root, int min, int max)
    {
        //base case if root is null return max - min
        //set min and max
        //return the max of both left and right subtrees
        
        if(root == null) return max - min;   
        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}