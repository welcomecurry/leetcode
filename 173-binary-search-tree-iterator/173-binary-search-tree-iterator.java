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
class BSTIterator {

    TreeNode root;
    List<Integer> tree;
    int pointer;
    
    public BSTIterator(TreeNode root) {
        root = root;
        tree = new ArrayList<>();
        pointer = 0;
        inorder(root);
    }
    
    public int next() {
        if(hasNext())
        {
            return tree.get(pointer++);
        }
        
        return -1;
    }
    
    public boolean hasNext() {
        return pointer < tree.size();
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        
        inorder(root.left);
        tree.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */