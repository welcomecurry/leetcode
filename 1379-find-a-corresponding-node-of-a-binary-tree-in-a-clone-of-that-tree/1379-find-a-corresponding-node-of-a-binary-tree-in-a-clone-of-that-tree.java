/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //hella wack problem, literally just do a bfs
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(cloned);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
                if(currNode.val == target.val)
                {
                    return currNode;
                }
                
                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }
        }
        
        return null;
    }
}