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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int i, int j)
    {
        if(i > j) return null;
        
        int val = preorder[i];
        TreeNode root = new TreeNode(val);
        
        int k;
        
        for(k = i + 1; k <= j; k++)
        {
            if(preorder[k] > val) break;
        }
        
        root.left = build(preorder, i + 1, k - 1);
        root.right = build(preorder, k, j);
        
        return root;
    }
}