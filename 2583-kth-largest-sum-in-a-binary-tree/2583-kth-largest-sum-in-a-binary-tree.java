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
    public long kthLargestLevelSum(TreeNode root, int k) {
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> levels = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            long currSum = 0;
            
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                currSum += curr.val;

                if(curr.left != null) queue.add(curr.left);

                if(curr.right != null) queue.add(curr.right);
            }

            levels.add(currSum);
        }
        
        if(k > levels.size()) return -1;

        while(!levels.isEmpty() && k-- > 1) levels.poll();

        return levels.poll();
    }
}