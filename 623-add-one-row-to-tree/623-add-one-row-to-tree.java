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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //bfs
        //base check if the depth is 1 make root v and make root to the left of node and return node
        //init level and queue
        //add root to queue
        //loop while queue is not empty
        //init size
        //loop through size
        //poll current node
        //if level == d - 1, we are on row we want to modify
            //cache left and right nodes of current node
            //make currentNode.left to new TreeNode(v) and do same for right
            //then .left.left = cachedLeft and same for right
        //add left and rights to queue
        //increment level at end of size loop
        //return root at end
        
        if(d == 1)
        {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
                
                if(level == d - 1)
                {
                    TreeNode currLeft = currNode.left, currRight = currNode.right;
                    
                    currNode.left = new TreeNode(v);
                    currNode.right = new TreeNode(v);
                    
                    currNode.left.left = currLeft;
                    currNode.right.right = currRight;
                    
                }
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
            }
            level++;
        }
        return root;
    }
}