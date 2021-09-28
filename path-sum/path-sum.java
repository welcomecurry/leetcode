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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base check
        //if root == null return false;
        //two stacks => node stack and sum stack
        //init with root and sum - root.val
        //while nodeStack is not empty
        //set currentnode to nodeStack.pop and set currentSum to sumStack.pop
        //if currentnode left and right are null and current sum is 0 
        //we found a path so true
        //if currentnode left is not null push onto stack and currSum - val onto stack
        //if currentnode right is not null push onto stack and currSum - val onto stack
        //if we get through loop there is no pathSum so return false
        
        if(root == null) return false;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        
        nodeStack.push(root);
        sumStack.push(targetSum - root.val);
        
        while(!nodeStack.isEmpty())
        {
            TreeNode currNode = nodeStack.pop();
            int currSum = sumStack.pop();
            
            //is leaf node
            if(currNode.left == null && currNode.right == null && currSum == 0) return true;
            
            if(currNode.left != null)
            {
                nodeStack.push(currNode.left);
                sumStack.push(currSum - currNode.left.val);
            }
            
            if(currNode.right != null)
            {
                nodeStack.push(currNode.right);
                sumStack.push(currSum - currNode.right.val);
            }
        }
        
        return false;
    }
}