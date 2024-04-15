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
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int sum) {
        //base check if root is null return
        //sum = sum * 10 + root.val => multiply by 10 to increase decimal place for next num then add next num
        //if left and right childs are null add sum to result since we have reached             root to leaf
        //recurse down left and right
        
        if(root == null) return;
        
        sum = sum * 10 + root.val;
        
        if(root.left == null && root.right == null) result += sum;
        
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}