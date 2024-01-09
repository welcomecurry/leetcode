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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //dfs and get both leaves and compare
        List<Integer> t1 = new ArrayList<>(), t2 = new ArrayList<>();
        dfs(root1, t1);
        dfs(root2, t2);
        return t1.equals(t2);
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if(root == null) return;

        if(root.left == null && root.right == null) leaves.add(root.val);

        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }
}