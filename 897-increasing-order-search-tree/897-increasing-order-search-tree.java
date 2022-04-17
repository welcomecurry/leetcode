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
    TreeNode newNode = new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        //inorder traversal to fill up list
        //init new treenode to 0
        //init pointer = newNode
        //loop through list
        //newNode = newNode.right = new TreeNode(i)
        //return newNode.right, since we init with 0
        if(root == null) return null;
        
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode output = new TreeNode(0);
        TreeNode pointer = output;
        
        for(int i : list)
        {
            pointer = pointer.right = new TreeNode(i);
        }
        
        return output.right;
    }
    
    private void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null) return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}