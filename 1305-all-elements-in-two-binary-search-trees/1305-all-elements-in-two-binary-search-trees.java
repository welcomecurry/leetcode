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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //perform inorder dfs on both roots and add to minHeap then return list
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        dfs(root1, minHeap);
        dfs(root2, minHeap);
        
        List<Integer> output = new ArrayList<>();
        
        while(!minHeap.isEmpty()) output.add(minHeap.poll());
        
        return output;
    }
    
    private void dfs(TreeNode root, PriorityQueue<Integer> minHeap)
    {
        if(root == null) return;
        
        dfs(root.left, minHeap);
        minHeap.add(root.val);
        dfs(root.right, minHeap);
    }
}