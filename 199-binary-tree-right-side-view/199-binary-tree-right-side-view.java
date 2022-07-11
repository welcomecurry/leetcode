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
    public List<Integer> rightSideView(TreeNode root) {
        //bfs
        //init result
        //we need the right most node of each level
        //do normal bfs
        //when we get to last element in current level, add to result
        
        List<Integer> output = new ArrayList<>();
        
        if(root == null) return output;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                
                if(size == 0) output.add(currNode.val);
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return output;
    }
}