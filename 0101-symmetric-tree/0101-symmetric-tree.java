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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode t1, TreeNode t2)
    {
        //we know that the left subtree of t1 must equal the right subtree of t2
        //and the right subtree of t1 must equal the left subtree of t2,
        //for them to be symetric, therefore we can devise a simple solution
        //if both of the nodes are null, we can continue and return true for that recursive call
        //if one node in either tree is null and one node from either tree is not null, the tree is not symmetric so return false
        //otherwise make sure that the current vals are equal
        //and recurese down respective subtrees to make sure they are equal
        
        if(t1 == null && t2 == null) return true;
        
        if(t1 == null || t2 == null) return false;
        
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}