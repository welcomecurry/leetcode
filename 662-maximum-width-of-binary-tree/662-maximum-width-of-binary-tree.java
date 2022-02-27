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
    public int widthOfBinaryTree(TreeNode root) {
        //bfs
        //keep weighted postions and take max of right - left + 1
        //For a fuIl binary tree, if parent node has position = i, 
        //then left-child's position = 2i and right-child's position = 2i + 1
        //Width of a level in the tree = position of last node - position of first node + 1
        int maxWidth = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, 0);
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int left = map.get(queue.peek());
            
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                maxWidth = Math.max(maxWidth, map.get(currNode) - left + 1);
                
                if(currNode.left != null)
                {
                    map.put(currNode.left, map.get(currNode) * 2);
                    queue.add(currNode.left);
                }
                
                if(currNode.right != null)
                {
                    map.put(currNode.right, map.get(currNode) * 2 + 1);
                    queue.add(currNode.right);
                }
            }
        }
        
        return maxWidth;
    }
}