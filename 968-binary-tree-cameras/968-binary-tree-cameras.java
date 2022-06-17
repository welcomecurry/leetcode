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
    
    int cameras;
    Set<TreeNode> coveredNodes;
    
    public int minCameraCover(TreeNode root) {
        
        if(root == null) return 0;
        
        cameras = 0;
        coveredNodes = new HashSet<>();
        
        coveredNodes.add(null); //add intital parent and leaf nodes
        
        dfs(root, null);
        
        return cameras;
    }
    
    private void dfs(TreeNode currNode, TreeNode parent)
    {
        if(currNode != null)
        {
            dfs(currNode.left, currNode);
            dfs(currNode.right, currNode);
            
            //check if we need to add a camera
            //if parent is null and currNode is not covered or either left or right childs not covered
            
            if(parent == null && !coveredNodes.contains(currNode) || !coveredNodes.contains(currNode.left) || !coveredNodes.contains(currNode.right))
            {
                cameras++;
                coveredNodes.add(currNode);
                coveredNodes.add(parent);
                coveredNodes.add(currNode.left);
                coveredNodes.add(currNode.right);
            }
        }
    }
}