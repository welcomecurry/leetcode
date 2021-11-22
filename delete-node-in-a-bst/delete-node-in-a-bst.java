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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key < root.val) //recurse left
        {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val) //recurse right
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            else
            {
                TreeNode temp = root.right;
                
                while(temp != null && temp.left != null)
                {
                    temp = temp.left;
                }
                
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        
        return root;
    }
}