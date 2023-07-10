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
    public int minDepth(TreeNode root) {
        //bfs
        //base check
        //create a queue
        //push the root onto the queue
        //depth var that is init at 1 since we are counting the root
        //while queue is not empty
        //get size
        //loop through from 0 to size
        //if node.left and right == null return the depth since we found a leaf node
        //add current node to queue
        //if node.left != null add to queue
        //if node.right != null add to queue
        //at end of for loop depth++
        //if we get through loop that means we have a skew tree so return depth
        
        if(root == null)
        {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode currentNode = queue.poll();
                
                if(currentNode.left == null && currentNode.right == null)
                {
                    return depth;
                }
                
                if(currentNode.left != null)
                {
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null)
                {
                    queue.add(currentNode.right);
                }
            }
            
            depth++;
        }
        
        return depth;
    }
}