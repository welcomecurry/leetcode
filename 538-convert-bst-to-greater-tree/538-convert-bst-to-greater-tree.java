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
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        //modified inorder, we want to traverse down right side first
        //if root is null return 0
        //traverse root.right
        //sum += val
        //root.val = sum
        //traverse root.left
        //root.val += sum
        
        if(root == null)
        {
            return null;
        }
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        
        return root;
    }
}