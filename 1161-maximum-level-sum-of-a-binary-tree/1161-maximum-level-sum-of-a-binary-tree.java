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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        int max = root.val, currLevel = 1, minLevel = 1;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                currSum += curr.val;
                
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            if(currSum > max) {
                max = currSum;
                minLevel = currLevel;
            }
            
            currLevel++;
        }
        
        return minLevel;
    }
}