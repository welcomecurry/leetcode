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
    List<Integer> tree = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        //inorder
        
        dfs(root);
        return tree.get(k - 1);
    }
    
    private void dfs(TreeNode root)
    {
        if(root == null) return;
        
        dfs(root.left);
        tree.add(root.val);
        dfs(root.right);
    }
}