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
    int numNodes = 0, temp = 0;
    public int averageOfSubtree(TreeNode root) {
        //do bfs on tree and for each node do dfs to get sum and check if average == nodeval
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0, sum = 0;
        while(!queue.isEmpty())
        {
            TreeNode currNode = queue.poll();
            numNodes = sum = temp = 0;

            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);

            dfs(currNode);
            sum += temp;

            if(sum / numNodes == currNode.val) count++;
        }
        
        return count;
    }
    
    private void dfs(TreeNode root)
    {
        if(root == null) return;
        
        dfs(root.left);
        temp += root.val;
        numNodes++;
        dfs(root.right);
        
    }
}