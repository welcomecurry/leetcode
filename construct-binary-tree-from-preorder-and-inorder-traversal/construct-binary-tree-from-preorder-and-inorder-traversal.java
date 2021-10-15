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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1, 0);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int start, int end, int index)
    {
        if(start > end) return null;
        
        TreeNode root = new TreeNode(preorder[index]);
        
        int inIndex = start;
        
        while(preorder[index] != inorder[inIndex]) inIndex++;
        
        root.left = build(preorder, inorder, start, inIndex - 1, index + 1);
        root.right = build(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1);
        
        return root;
    }
}