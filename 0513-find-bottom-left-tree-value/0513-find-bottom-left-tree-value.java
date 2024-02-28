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
    public int findBottomLeftValue(TreeNode root) {
        //bfs
        //when we are on first element on any row, assign it to output
        
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                
                if(i == 0) { //we are on first element on current level
                    ans = currNode.val;
                }
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return ans;
    }
}