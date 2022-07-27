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
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        
        preOrder(root);
        
        root.left = null;
        root.right = null;
        
        TreeNode pointer = root;

        for(int i = 1; i < tree.size(); i++)
        {
            pointer.right = new TreeNode(tree.get(i));
            pointer = pointer.right;
        }
    }
    
    private void preOrder(TreeNode root)
    {
        if(root == null) return;
        
        tree.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}