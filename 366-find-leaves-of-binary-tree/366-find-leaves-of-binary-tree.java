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
    List<List<Integer>> leaves = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        //remove all leaves while root is not null
        
        int currTreeIndex = 0;
        
        while(root != null) {
            leaves.add(new ArrayList<>());
            root = removeLeaves(root, currTreeIndex++);
        }
        
        return leaves;
    }
    
    private TreeNode removeLeaves(TreeNode root, int index) {
        if(root == null) return null;
        
        if(root.left == null && root.right == null) {
            leaves.get(index).add(root.val);
            return null;
        }
        
        root.left = removeLeaves(root.left, index);
        root.right = removeLeaves(root.right, index);
        
        return root;
    }
}