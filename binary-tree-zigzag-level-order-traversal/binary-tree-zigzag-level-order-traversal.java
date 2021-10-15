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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //for every odd level, reverse array an append
        
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null) return output;
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                curr.add(currNode.val);
                
                if(currNode.left != null) queue.add(currNode.left);
                
                if(currNode.right != null) queue.add(currNode.right);
            }
            
            if(level % 2 != 0) Collections.reverse(curr);

            output.add(curr);
            
            level++;
        }
        
        return output;
    }
}