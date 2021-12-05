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
    
    Map<TreeNode, Integer> dp = new HashMap<>();
    
    public int rob(TreeNode root) {
        //base case if the root is null return 0
        //second case, if we have already visited node just return the value
        //at this point the robber has 2 options, rob or don't rob the current house
        //lets rob left and right
        //then don't rob left and right
        //return max of robbing and not robbing
        
        if(root == null) return 0;
        
        if(dp.containsKey(root)) return dp.get(root);
        
        int robHouse = root.val;
        
        robHouse += root.left == null ? 0 : rob(root.left.left) + rob(root.left.right);
        robHouse += root.right == null ? 0 : rob(root.right.left) + rob(root.right.right);
        
        int noRob = 0;
        noRob += rob(root.left) + rob(root.right);
        
        int output = Math.max(robHouse, noRob);
        dp.put(root, output);
        return output;
    }
}