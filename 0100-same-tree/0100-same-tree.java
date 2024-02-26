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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //if both nodes are null return true => same tree
        //if one of p and q are null return false => not the same tree
        //if p.val != q.val return false => not the same tree
        //otherwise return isSameTree(left) && isSameTree(right)
        
        if(p == null && q == null)
        {
            return true;
        }
        
        if(p == null || q == null)
        {
            return false;
        }
        
        if(p.val != q.val)
        {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}