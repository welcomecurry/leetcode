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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart)
    {
        //base case if postStart < 0 or inStart < inEnd return null
        //last element in postorder is root so create root
        
        if(postStart < 0 || inStart < inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        
        int rootIndex = inStart;
        
        //find the index of the root from inorder. Iterating from the end.
        for(int i = inStart; i >= inEnd; i--) 	
        {
            if(inorder[i] == postorder[postStart])
            {
                rootIndex = i;
                break;
            }
        }
        
        root.right = build(inorder, inStart, rootIndex + 1, postorder, postStart - 1);
        root.left = build(inorder, rootIndex - 1, inEnd, postorder, postStart - (inStart - rootIndex) - 1);
        
        return root;
    }
}