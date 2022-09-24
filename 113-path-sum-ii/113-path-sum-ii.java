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
    
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPaths(root, new ArrayList<>(), 0, targetSum);
        return output;
    }
    
    private void findPaths(TreeNode root, List<Integer> curr, int sum, int targetSum)
    {
        //base case if the root is null return
        //otherwise add the current node to curr
        //if we are at a leaf node and sum + root.val == targetSum, add curr to output and return
        //recurse on the left and right sides
        
        if(root == null) return;
        
        curr.add(root.val);
        
        if(root.left == null && root.right == null && sum + root.val == targetSum)
        {
            output.add(new ArrayList<>(curr));
            return;
        }
        
        findPaths(root.left, new ArrayList<>(curr), sum + root.val, targetSum);
        findPaths(root.right, new ArrayList<>(curr), sum + root.val, targetSum);
    }
}