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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //base check if root is null return null
        //if root.val < low, traverse the right side
        //if root.val > high, traverse the left side
        //root.left = trimming of left side
        //root.right = trimming of right side
        //simply return root
        
        if(root == null)
        {
            return null;
        }
        
        if(root.val < low)
        {
            return trimBST(root.right, low, high);
        }
        
        if(root.val > high)
        {
            return trimBST(root.left, low, high);
        }
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }
}