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
    public boolean isEvenOddTree(TreeNode root) {
        //even levels must have odd values and increasing
        //odd levels must have even values and decreasing
        //base check, if the roots value is not odd return false
        //init queue and add root
        //init level
        //loop through while queue is not empty
        //init size and loop through current level
        //set bound based on current level, so first element can pass check
        //if current level is even and values are even or decreasing return false
        //if the current level is odd and values are odd or increasing return false
        //if currNode.left is not null, add to queue
        //if currNode.right is not null, add to queue
        //set current bound to current val
        //increment level
        //if we get through whole traversal the tree is even/odd so return true
        
        if(root.val % 2 == 0)
        {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int bound = 0;
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            bound = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
                
                if(level % 2 == 0 && (currNode.val % 2 == 0 || currNode.val <= bound) || level % 2 != 0 && (currNode.val % 2 != 0 || currNode.val >= bound))
                {
                    return false;
                }
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
                
                bound = currNode.val;
            }
            level++;
        }
        
        return true;
    }
    
}