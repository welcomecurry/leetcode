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
    public int deepestLeavesSum(TreeNode root) {
        //bfs, keep computing sum of each level, last sum level will be deepest leaves so return sum
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            sum = 0; //reset sum if we are not on deepest leaves
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                sum += currNode.val;
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return sum;
    }
}