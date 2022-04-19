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
    public void recoverTree(TreeNode root) {
        //perform inorder to get bst
        //sort values
        //then loop through nodes and set values
        
        List<Integer> vals = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        
        inorder(root, vals, nodes);
        Collections.sort(vals);
        
        for(int i = 0; i < nodes.size(); i++)
        {
            nodes.get(i).val = vals.get(i);
        }
    }
    
    private void inorder(TreeNode root, List<Integer> vals, List<TreeNode> nodes)
    {
        if(root == null) return;
        
        inorder(root.left, vals, nodes);
        vals.add(root.val);
        nodes.add(root);
        inorder(root.right, vals, nodes);
    }
}